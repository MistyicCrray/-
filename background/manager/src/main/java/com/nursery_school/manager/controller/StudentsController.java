package com.nursery_school.manager.controller;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.github.pagehelper.StringUtil;
import com.nursery_school.manager.model.Student;
import com.nursery_school.manager.model.User;
import com.nursery_school.manager.service.StudentService;
import com.nursery_school.manager.tools.CurrentUser;
import com.nursery_school.manager.tools.LoginRequired;
import com.nursery_school.manager.tools.Result;
import com.nursery_school.manager.tools.ResultGenerator;
import com.nursery_school.manager.tools.TableData;

@RestController
@RequestMapping("/student")
public class StudentsController {

	@Autowired
	private StudentService studentService;

	@LoginRequired(value = "3")
	@RequestMapping(value = "/findByDyna", method = RequestMethod.GET)
	public Result findByDyna(@RequestParam(required = false) Map<String, Object> map, Integer pageNum, Integer size,
			@CurrentUser User user) {
		Page<Student> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size);
		List<Student> findByDyna = studentService.findByDyna(map);
		return ResultGenerator.genSuccessResult(new TableData<Student>(page.getTotal(), findByDyna));
	}

	@LoginRequired(value = "3")
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public Result addUser(@RequestBody Map<String, Object> map, @CurrentUser User cruse)
			throws IllegalAccessException, InvocationTargetException, ParseException {
		Student student = new Student();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (map.get("birthday") != null) {
			if (StringUtil.isNotEmpty(map.get("birthday").toString())) {
				Date birthday = sdf.parse(map.get("birthday").toString());
				map.put("birthday", birthday);
			}
		} else {
			map.put("birthday", new Date());
		}
		if (map.get("inDate") != null) {
			Date inDate = sdf.parse(map.get("inDate").toString());
			map.put("inDate", inDate);
		} else {
			map.put("inDate", new Date());
		}
		BeanUtils.populate(student, map);
		studentService.addStudent(student);
		return ResultGenerator.genSuccessResult("添加成功");
	}

	@LoginRequired(value = "3")
	@RequestMapping(value = "/updateStudent/{id}", method = RequestMethod.POST)
	public Result update(@RequestBody Map<String, Object> map, @CurrentUser User cruse,@PathVariable String id) {
		map.put("id", id);
		studentService.update(map);
		return ResultGenerator.genSuccessResult("修改成功");
	}
	
	@LoginRequired(value = "3")
	@RequestMapping(value = "/deleteStudent/{id}", method = RequestMethod.POST)
	public Result update(@PathVariable String id) {
		studentService.delete(id);
		return ResultGenerator.genSuccessResult("删除成功");
	}
}
