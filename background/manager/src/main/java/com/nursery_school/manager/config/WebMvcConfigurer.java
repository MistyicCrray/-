package com.nursery_school.manager.config;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.nursery_school.manager.interceptor.AuthenticationInterceptor;
import com.nursery_school.manager.interceptor.CurrentUserMethodArgumentResolver;
import com.nursery_school.manager.tools.AuthorizationException;
import com.nursery_school.manager.tools.Result;
import com.nursery_school.manager.tools.ResultCode;
import com.nursery_school.manager.tools.ServiceException;

/**
 * Spring MVC
 */
@SuppressWarnings("deprecation")
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	private final Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);
	@Value("${spring.profiles.active}")
	private String env;

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(currentUserMethodArgumentResolver());
		// TODO Auto-generated method stub
		super.addArgumentResolvers(argumentResolvers);
	}

	@Bean
	public AuthenticationInterceptor authenticationInterceptor() {
		return new AuthenticationInterceptor();
	}

	/**
	 * 配置CurrentUser
	 * 
	 * @Title: currentUserMethodArgumentResolver
	 * @Description: TODO
	 * @return CurrentUserMethodArgumentResolver
	 */
	@Bean
	public CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver() {
		return new CurrentUserMethodArgumentResolver();
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		FastJsonConfig config = new FastJsonConfig();
		config.setSerializerFeatures(SerializerFeature.WriteMapNullValue);
		converter.setFastJsonConfig(config);
		converter.setDefaultCharset(Charset.forName("UTF-8"));
		converters.add(converter);
	}

	// 统一异常处理
	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		exceptionResolvers.add(new HandlerExceptionResolver() {
			public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
					Object handler, Exception e) {
				Result result = new Result();
				if (e instanceof ServiceException) {
					response.setStatus(400);
					result.setCode(ResultCode.FAIL).setMessage(e.getMessage());
					logger.info(e.getMessage());
				} else if (e instanceof AuthorizationException) {
					response.setStatus(401);
					result.setCode(ResultCode.UNAUTHORIZED).setMessage(e.getMessage());
					logger.info(e.getMessage());
				} else if (e instanceof NoHandlerFoundException) {
					response.setStatus(404);
					result.setCode(ResultCode.NOT_FOUND).setMessage("接口 [" + request.getRequestURI() + "] 不存在");
				} else if (e instanceof ServletException) {
					result.setCode(ResultCode.FAIL).setMessage(e.getMessage());
				} else {
					response.setStatus(500);
					result.setCode(ResultCode.INTERNAL_SERVER_ERROR)
							.setMessage("接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员");
					String message;
					if (handler instanceof HandlerMethod) {
						HandlerMethod handlerMethod = (HandlerMethod) handler;
						message = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s", request.getRequestURI(),
								handlerMethod.getBean().getClass().getName(), handlerMethod.getMethod().getName(),
								e.getMessage());
					} else {
						message = e.getMessage();
					}
					logger.error(message, e);
				}

				responseResult(response, result);
				return new ModelAndView();
			}

		});
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**");
	}

	private void responseResult(HttpServletResponse response, Result result) {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "application/json;charset=UTF-8");
		try {
			response.getWriter().write(JSON.toJSONString(result));
		} catch (IOException ex) {
			logger.error(ex.getMessage());
		}
	}

	// 添加拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 接口签名认证拦截器，该签名认证比较简单，实际项目中可以使用Json Web Token或其他更好的方式替代。
		if (!"dev".equals(env)) { // 开发环境忽略签名认证
			registry.addInterceptor(new HandlerInterceptorAdapter() {
				@Override
				public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
						throws Exception {
					// 验证签名
					boolean pass = validateSign(request);
					if (pass) {
						return true;
					} else {
						logger.warn("签名认证失败，请求接口：{}，请求IP：{}，请求参数：{}", request.getRequestURI(), getIpAddress(request),
								JSON.toJSONString(request.getParameterMap()));

						Result result = new Result();
						result.setCode(ResultCode.UNAUTHORIZED).setMessage("签名认证失败");
						response.setStatus(401);
						responseResult(response, result);
						return false;
					}
				}
			});
		}
		// addPathPatterns 用于添加拦截规则
		// excludePathPatterns 用户排除拦截
		registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}

	/**
	 * 一个简单的签名认证，规则： 1. 将请求参数按ascii码排序 2. 拼接为a=value&b=value...这样的字符串（不包含sign） 3.
	 * 混合密钥（secret）进行md5获得签名，与请求的签名进行比较
	 */
	private boolean validateSign(HttpServletRequest request) {
		String requestSign = request.getParameter("sign");// 获得请求签名，如sign=19e907700db7ad91318424a97c54ed57
		if (StringUtils.isEmpty(requestSign)) {
			return false;
		}
		List<String> keys = new ArrayList<String>(request.getParameterMap().keySet());
		keys.remove("sign");// 排除sign参数
		Collections.sort(keys);// 排序

		StringBuilder sb = new StringBuilder();
		for (String key : keys) {
			sb.append(key).append("=").append(request.getParameter(key)).append("&");// 拼接字符串
		}
		String linkString = sb.toString();
		linkString = StringUtils.substring(linkString, 0, linkString.length() - 1);// 去除最后一个'&'

		String secret = "Potato";// 密钥，自己修改
		String sign = DigestUtils.md5Hex(linkString + secret);// 混合密钥md5

		return StringUtils.equals(sign, requestSign);// 比较
	}

	private String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		// 如果是多级代理，那么取第一个ip为客户端ip
		if (ip != null && ip.indexOf(",") != -1) {
			ip = ip.substring(0, ip.indexOf(",")).trim();
		}

		return ip;
	}
	
}