package com.nursery_school.manager.controller;

import java.util.HashMap;
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
import com.nursery_school.manager.model.Parents;
import com.nursery_school.manager.model.Student;
import com.nursery_school.manager.service.ParentService;
import com.nursery_school.manager.service.StudentService;
import com.nursery_school.manager.tools.LoginRequired;
import com.nursery_school.manager.tools.Result;
import com.nursery_school.manager.tools.ResultGenerator;
import com.nursery_school.manager.tools.TableData;

@RestController
@RequestMapping("/parents")
public class ParentsController {

	@Autowired
	private ParentService parentService;

	@Autowired
	private StudentService studentService;

	// 查询用户和家长表（单个）
	@LoginRequired(value = "3")
	@RequestMapping(value = "/findUserAnparents/{pid}", method = RequestMethod.GET)
	public Result findUserAnparents(@PathVariable(value = "pid") String pid) {
		return ResultGenerator.genSuccessResult(parentService.findParentsAnUser(pid));
	}

	// 查询用户和家长表（全部）
	@LoginRequired(value = "3")
	@RequestMapping(value = "/findUserAnParents", method = RequestMethod.GET)
	public Result findUserAnParents(@RequestParam(required = false) Map<String, Object> map, Integer pageNum,
			Integer size) {
		Page<List<Map<String, Object>>> page = PageHelper.startPage(pageNum == null ? 1 : pageNum,
				size == null ? 5 : size);
		List<Map<String, Object>> selectUserAnParents = parentService.selectUserAnParents(map);
		for (Map<String, Object> map2 : selectUserAnParents) {
			Map<String, Object> mapstu = new HashMap<>();
			mapstu.put("parentId", map2.get("p_id"));
			List<Student> findByDyna = studentService.findByDyna(mapstu);
			map2.put("count", findByDyna.size());
		}
		return ResultGenerator.genSuccessResult(new TableData<Map<String, Object>>(page.getTotal(), selectUserAnParents));
	}

	// 查询家长的孩子
	@LoginRequired(value = "3")
	@RequestMapping(value = "/findParentChils/{pid}", method = RequestMethod.GET)
	public Result findParentChils(@PathVariable(value = "pid") String pid, Integer pageNum, Integer size) {
		Page<List<Map<String, Object>>> page = PageHelper.startPage(pageNum == null ? 1 : pageNum,
				size == null ? 5 : size);
		List<Map<String, Object>> findParentChils = parentService.findParentChils(pid);
		return ResultGenerator.genSuccessResult(new TableData<Map<String, Object>>(page.getTotal(), findParentChils));
	}

	// 修改家长信息
	@LoginRequired(value = "3")
	@RequestMapping(value = "/updateParents/{pid}", method = RequestMethod.POST)
	public Result updateParents(@RequestBody Map<String, Object> map, @PathVariable(value = "pid") String pid) {
		map.put("id", pid);
		map.put("password", "");
		parentService.update(map);
		return ResultGenerator.genSuccessResult();
	}

	// 添加家长信息
	@LoginRequired(value = "3")
	@RequestMapping(value = "/addParents", method = RequestMethod.POST)
	public Result addParents(@RequestBody Map<String, Object> map) {
		Parents add = parentService.add(map);
		if (add == null) {
			return ResultGenerator.genFailResult("添加失败，用户名重复");
		}
		return ResultGenerator.genSuccessResult(add);
	}

}
