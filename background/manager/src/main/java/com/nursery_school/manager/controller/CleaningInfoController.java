package com.nursery_school.manager.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nursery_school.manager.model.Cleaning;
import com.nursery_school.manager.model.CleaningInfo;
import com.nursery_school.manager.model.Staff;
import com.nursery_school.manager.model.User;
import com.nursery_school.manager.service.CleaningInfoService;
import com.nursery_school.manager.service.CleaningService;
import com.nursery_school.manager.service.StaffService;
import com.nursery_school.manager.tools.CurrentUser;
import com.nursery_school.manager.tools.LoginRequired;
import com.nursery_school.manager.tools.Result;
import com.nursery_school.manager.tools.ResultGenerator;
import com.nursery_school.manager.tools.TableData;

@RequestMapping("/cleaningInfo")
@RestController
public class CleaningInfoController {

	@Autowired
	private CleaningInfoService cleaningInfoService;

	@Autowired
	private StaffService staffService;

	@Autowired
	private CleaningService cleaningService;

	@LoginRequired(value = "5")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result add(@RequestParam(required = false) Map<String, Object> map, @CurrentUser User currentUser,
			@RequestParam(required = false) MultipartFile image) throws ParseException {
		cleaningInfoService.add(map, image);
		return ResultGenerator.genSuccessResult("添加成功");
	}

	@LoginRequired(value = "5")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public Result delete(@PathVariable String id, @CurrentUser User currentUser) {
		cleaningInfoService.delete(id);
		return ResultGenerator.genSuccessResult("删除成功");
	}

	@LoginRequired(value = "5")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public Result update(@PathVariable String id, @RequestParam(required = false) Map<String, Object> map,
			@CurrentUser User currentUser, MultipartFile img) {
		map.put("id", id);
		cleaningInfoService.update(map, img);
		return ResultGenerator.genSuccessResult("修改成功");
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public Result find(@RequestParam(required = false) Map<String, Object> map, Integer pageNum, Integer size) {
		Page<CleaningInfo> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size);
		List<CleaningInfo> findByDyna = cleaningInfoService.findByDyna(map);
		return ResultGenerator.genSuccessResult(new TableData<CleaningInfo>(page.getTotal(), findByDyna));
	}

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public Result find(@PathVariable String id) {
		CleaningInfo cleaningInfo = cleaningInfoService.findById(id);
		Staff staff = staffService.findById(cleaningInfo.getStaffId());
		cleaningInfo.setStaff(staff);
		Cleaning cleaning = cleaningService.findById(cleaningInfo.getCleaningId());
		cleaningInfo.setCleaning(cleaning);
		return ResultGenerator.genSuccessResult(cleaningInfo);
	}
}
