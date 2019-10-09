package com.nursery_school.manager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public Result add(@RequestBody PayStandard payStandard, @CurrentUser User currentUser) {
		payStandardService.add(payStandard);
		return ResultGenerator.genSuccessResult("添加成功");
	}

	@LoginRequired(value = "3")
	@RequestMapping(value = "/findByList", method = RequestMethod.GET)
	public Result findByList(@RequestParam(required = false) Map<String, Object> map, Integer pageNum, Integer size,
			@CurrentUser User user) {
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
	public Result update(@PathVariable String id, @RequestBody Map<String, Object> map, @CurrentUser User currentUser) {
		map.put("id", id);
		payStandardService.update(map);
		return ResultGenerator.genSuccessResult("修改成功");
	}

	@LoginRequired(value = "3")
	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id, @CurrentUser User currentUser) {
		return ResultGenerator.genSuccessResult(payStandardService.findById(id));
	}
	
}
