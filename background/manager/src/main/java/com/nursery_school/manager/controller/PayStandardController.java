package com.nursery_school.manager.controller;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nursery_school.manager.model.PayStandard;
import com.nursery_school.manager.model.User;
import com.nursery_school.manager.service.PayStandardService;
import com.nursery_school.manager.tools.CurrentUser;
import com.nursery_school.manager.tools.LoginRequired;
import com.nursery_school.manager.tools.Result;
import com.nursery_school.manager.tools.ResultGenerator;
import com.nursery_school.manager.tools.TableData;

@RestController
@RequestMapping("/payStandard")
public class PayStandardController {

	@Autowired
	private PayStandardService payStandardService;

	@LoginRequired(value = "3")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result add(@RequestParam(required = false) Map<String, Object> map, @CurrentUser User currentUser,
			@RequestParam(required = false) MultipartFile file)
			throws IllegalAccessException, InvocationTargetException, ParseException {
		PayStandard payStandard = new PayStandard();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		map.put("year", sdf.parse(map.get("year").toString()));
		map.put("paymentDeadline", sdf.parse(map.get("paymentDeadline").toString()));
		BeanUtils.populate(payStandard, map);
		payStandardService.add(payStandard, file);
		return ResultGenerator.genSuccessResult("添加成功");
	}

	@RequestMapping(value = "/findByList", method = RequestMethod.GET)
	public Result findByList(@RequestParam(required = false) Map<String, Object> map, Integer pageNum, Integer size) {
		Page<PayStandard> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size);
		List<PayStandard> findByList = payStandardService.selectProvider(map);
		return ResultGenerator.genSuccessResult(new TableData<PayStandard>(page.getTotal(), findByList));
	}

	@LoginRequired(value = "3")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public Result add(@PathVariable String id, @CurrentUser User currentUser) {
		payStandardService.delete(id);
		return ResultGenerator.genSuccessResult("删除成功");
	}

	@LoginRequired(value = "3")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public Result update(@PathVariable String id, @RequestParam(required = false) Map<String, Object> map,
			@CurrentUser User currentUser, @RequestParam(required = false) MultipartFile file) {
		map.put("id", id);
		payStandardService.update(map, file);
		return ResultGenerator.genSuccessResult("修改成功");
	}

	@LoginRequired(value = "3")
	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id, @CurrentUser User currentUser) {
		return ResultGenerator.genSuccessResult(payStandardService.findById(id));
	}

}
