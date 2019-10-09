package com.nursery_school.manager.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nursery_school.manager.model.Communication;
import com.nursery_school.manager.model.User;
import com.nursery_school.manager.service.CommunicationService;
import com.nursery_school.manager.service.UserService;
import com.nursery_school.manager.tools.CurrentUser;
import com.nursery_school.manager.tools.LoginRequired;
import com.nursery_school.manager.tools.Result;
import com.nursery_school.manager.tools.ResultGenerator;
import com.nursery_school.manager.tools.TableData;

@RestController
@RequestMapping("/communication")
public class CommunicationController {

	@Autowired
	private CommunicationService communicationService;

	@Autowired
	private UserService userService;

	@Value("${communication_open_time}")
	private int openTime;

	@Value("${communication_close_time}")
	private int closeTime;

	@LoginRequired(value = "1,2")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result add(@RequestBody Communication communication, @CurrentUser User cuser) {
		Date nowDate = new Date();
		@SuppressWarnings("deprecation")
		int hours = nowDate.getHours();

		if (hours < openTime || hours > closeTime) {
			return ResultGenerator.genFailResult("模块尚未开放");
		}

		communication.setUserId(cuser.getId());
		communicationService.add(communication);
		return ResultGenerator.genSuccessResult("添加成功");
	}

	@LoginRequired(value = "1,2")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public Result delete(@PathVariable String id, @CurrentUser User cuser) {
		communicationService.delete(id);
		return ResultGenerator.genSuccessResult("删除成功");
	}

	@LoginRequired(value = "1,2")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Result update(@RequestBody Map<String, Object> map, @CurrentUser User cuser) {
		communicationService.update(map);
		return ResultGenerator.genSuccessResult("修改成功");
	}

	@LoginRequired(value = "1,2")
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public Result find(@RequestParam(required = false) Map<String, Object> map, Integer pageNum, Integer size,
			@CurrentUser User currentUser) {
		Date nowDate = new Date();
		@SuppressWarnings("deprecation")
		int hours = nowDate.getHours();

		if (hours < openTime || hours > closeTime) {
			return ResultGenerator.genFailResult("模块尚未开放，开放时间为：" + openTime + "点~" + closeTime + "点");

		}

		Page<Communication> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size);
		map.put("userId", currentUser.getId());
		List<Communication> findByDyna = communicationService.findByDyna(map);
		for (Communication communication : findByDyna) {
			User user = userService.findById(communication.getUserId());
			User toUser = userService.findById(communication.getToUserId());
			communication.setToUser(toUser);
			communication.setUser(user);
		}
		return ResultGenerator.genSuccessResult(new TableData<Communication>(page.getTotal(), findByDyna));
	}

	@LoginRequired(value = "1,2")
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id, @CurrentUser User currentUser) {
		Date nowDate = new Date();
		@SuppressWarnings("deprecation")
		int hours = nowDate.getHours();

		if (hours < openTime || hours > closeTime) {
			return ResultGenerator.genFailResult("模块尚未开放");
		}

		Communication communication = communicationService.findById(id);
		User user = userService.findById(communication.getUserId());
		User toUser = userService.findById(communication.getToUserId());
		communication.setToUser(toUser);
		communication.setUser(user);
		return ResultGenerator.genSuccessResult(communication);
	}

}
