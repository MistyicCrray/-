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
import com.nursery_school.manager.model.Reply;
import com.nursery_school.manager.model.User;
import com.nursery_school.manager.service.ReplyService;
import com.nursery_school.manager.service.UserService;
import com.nursery_school.manager.tools.CurrentUser;
import com.nursery_school.manager.tools.LoginRequired;
import com.nursery_school.manager.tools.Result;
import com.nursery_school.manager.tools.ResultGenerator;
import com.nursery_school.manager.tools.TableData;

@RestController
@RequestMapping("/reply")
public class ReplyController {

	@Autowired
	private ReplyService reService;

	@Autowired
	private UserService userService;

	@LoginRequired(value = "1,2")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result add(@RequestBody Reply reply, @CurrentUser User cuser) {
		reply.setSendUserId(cuser.getId());
		
		reService.add(reply);
		return ResultGenerator.genSuccessResult("添加成功");
	}

	@LoginRequired(value = "1,2")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public Result delete(@PathVariable String id, @CurrentUser User cuser) {
		reService.delete(id);
		return ResultGenerator.genSuccessResult("删除成功");
	}

//	@LoginRequired
//	@RequestMapping(value = "/update", method = RequestMethod.POST)
//	public Result update(@RequestBody Map<String, Object> map, @CurrentUser User cuser) {
//		reService.update(map);
//		return ResultGenerator.genSuccessResult("修改成功");
//	}

	@LoginRequired(value = "1,2")
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public Result find(@RequestParam(required = false) Map<String, Object> map, Integer pageNum, Integer size,
			@CurrentUser User currentUser) {
		Page<Reply> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size);
		map.put("userId", currentUser.getId());
		List<Reply> findByDyna = reService.findByDyna(map);
		for (Reply reply : findByDyna) {
			User user = userService.findById(reply.getSendUserId());
			User toUser = userService.findById(reply.getToUserId());
			reply.setToUser(toUser);
			reply.setUser(user);
		}
		return ResultGenerator.genSuccessResult(new TableData<Reply>(page.getTotal(), findByDyna));
	}

}
