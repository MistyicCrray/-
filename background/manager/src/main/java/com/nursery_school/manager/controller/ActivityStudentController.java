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
import com.nursery_school.manager.model.ActivityStudent;
import com.nursery_school.manager.model.User;
import com.nursery_school.manager.service.ActivityStudentService;
import com.nursery_school.manager.tools.CurrentUser;
import com.nursery_school.manager.tools.LoginRequired;
import com.nursery_school.manager.tools.Result;
import com.nursery_school.manager.tools.ResultGenerator;
import com.nursery_school.manager.tools.TableData;

@RequestMapping("/activityStudent")
@RestController
public class ActivityStudentController {

	@Autowired
	private ActivityStudentService activityStudentService;

	@LoginRequired(value = "5")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result add(@RequestParam(required = false) Map<String, Object> map) {
		activityStudentService.add(map);
		return ResultGenerator.genSuccessResult("添加成功");
	}

	@LoginRequired(value = "5")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public Result delete(@PathVariable String id, @CurrentUser User currentUser) {
		activityStudentService.delete(id);
		return ResultGenerator.genSuccessResult("删除成功");
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public Result find(@RequestParam(required = false) Map<String, Object> map, Integer pageNum, Integer size) {
		Page<ActivityStudent> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size);
		List<ActivityStudent> findByDyna = activityStudentService.findByDyna(map);
		return ResultGenerator.genSuccessResult(new TableData<ActivityStudent>(page.getTotal(), findByDyna));
	}

	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id) {
		return ResultGenerator.genSuccessResult(activityStudentService.findById(id));
	}
}
