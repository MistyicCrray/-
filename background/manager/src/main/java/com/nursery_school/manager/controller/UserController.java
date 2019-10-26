package com.nursery_school.manager.controller;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nursery_school.manager.model.User;
import com.nursery_school.manager.service.UserService;
import com.nursery_school.manager.tools.CurrentUser;
import com.nursery_school.manager.tools.LoginRequired;
import com.nursery_school.manager.tools.MD5;
import com.nursery_school.manager.tools.Result;
import com.nursery_school.manager.tools.ResultGenerator;
import com.nursery_school.manager.tools.TableData;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 管理员添加用户
	 * 
	 * @param map
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws ParseException
	 */
	@LoginRequired(value = "0")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Result addUser(@RequestBody Map<String, Object> map, @CurrentUser User cruse)
			throws IllegalAccessException, InvocationTargetException, ParseException {
		if (!cruse.getUserType().equals(0)) {
			return ResultGenerator.genFailResult("你没有操作权限");
		}
		User user = new User();
		BeanUtils.populate(user, map);
		if (userService.findByLoginName(user.getLoginName()) != null) {
			return ResultGenerator.genFailResult("添加失败，该账号已存在");
		}
		userService.addUser(user);
		return ResultGenerator.genSuccessResult("添加成功");
	}

	/**
	 * 查询所有用户信息
	 * 
	 * @throws ParseException
	 */
	@LoginRequired(value = "0")
	@RequestMapping(value = "/findAllUser", method = RequestMethod.GET)
	public Result addUser(@RequestParam(required = false) Map<String, Object> map, Integer pageNum, Integer size,
			@CurrentUser User cruse) {
		if (!cruse.getUserType().equals(0)) {
			return ResultGenerator.genFailResult("你没有操作权限");
		}
		Page<User> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size);
		List<User> findUserAll = userService.findDymic(map);
		return ResultGenerator.genSuccessResult(new TableData<User>(page.getTotal(), findUserAll));
	}

	/**
	 * 登录
	 * 
	 * @param map
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Result login(@RequestBody Map<String, Object> map) throws IllegalAccessException, InvocationTargetException {
		User user = new User();
		BeanUtils.populate(user, map);
		Map<String, Object> login = userService.login(user);
		if (login == null) {
			return ResultGenerator.genFailResult("用户名或密码错误");
		}
		User curUser = (User) login.get("userInfo");
		if (curUser.getState().equals(1)) {
			return ResultGenerator.genFailResult("账号已被冻结，请联系管理员");
		}
		return ResultGenerator.genSuccessResult(login);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @param cruse
	 * @return
	 */
	@LoginRequired(value = "0")
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.POST)
	public Result deleteUser(@PathVariable String id, @CurrentUser User cruse) {
		if (!cruse.getUserType().equals(0)) {
			return ResultGenerator.genFailResult("你没有操作权限");
		}
		if (userService.findById(id).getUserType().equals(0)) {
			return ResultGenerator.genFailResult("管理员用户不能删除");
		}
		userService.deleteUser(id);
		return ResultGenerator.genSuccessResult("删除成功");
	}

	/**
	 * 修改
	 * 
	 * @param cruse
	 * @return
	 */
	@LoginRequired(value = "0")
	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.POST)
	public Result update(@RequestBody Map<String, Object> map, @PathVariable(value = "id") String id,
			@CurrentUser User cruse) {
		map.put("id", id);
		userService.updateDymic(map);
		return ResultGenerator.genSuccessResult("修改成功");
	}

	/**
	 * 修改密码
	 * 
	 * @param cruse
	 * @return
	 */
	@LoginRequired(value = "0,1,2,3,4,5")
	@RequestMapping(value = "/updatePwd/{password}/{oldP}", method = RequestMethod.POST)
	public Result updatePwd(@PathVariable(value = "password") String password,@PathVariable(value = "oldP") String oldP, @CurrentUser User cruse) {
		String md5 = MD5.md5(oldP);
		if (!md5.equals(cruse.getPassword())) {
			return ResultGenerator.genFailResult("旧密码不正确");
		}
		userService.updatePwd(password, cruse);
		return ResultGenerator.genSuccessResult("修改成功");
	}
}
