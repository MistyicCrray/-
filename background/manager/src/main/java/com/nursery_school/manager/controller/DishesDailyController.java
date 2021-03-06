package com.nursery_school.manager.controller;

import java.util.ArrayList;
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
import com.nursery_school.manager.model.Dishes;
import com.nursery_school.manager.model.DishesDaily;
import com.nursery_school.manager.model.User;
import com.nursery_school.manager.service.DishesDailyService;
import com.nursery_school.manager.service.DishesService;
import com.nursery_school.manager.tools.CurrentUser;
import com.nursery_school.manager.tools.LoginRequired;
import com.nursery_school.manager.tools.Result;
import com.nursery_school.manager.tools.ResultGenerator;
import com.nursery_school.manager.tools.TableData;

@RequestMapping("/dishesDaily")
@RestController
public class DishesDailyController {

	@Autowired
	private DishesDailyService dishesDailyService;

	@Autowired
	private DishesService dishesService;

	@LoginRequired(value = "4")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result add(@RequestBody DishesDaily cleaning, @CurrentUser User currentUser) {
		dishesDailyService.add(cleaning);
		return ResultGenerator.genSuccessResult("添加成功");
	}

	@LoginRequired(value = "4")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public Result delete(@PathVariable String id, @CurrentUser User currentUser) {
		dishesDailyService.delete(id);
		return ResultGenerator.genSuccessResult("删除成功");
	}

	@LoginRequired(value = "4")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public Result update(@PathVariable String id,@RequestBody Map<String, Object> map, @CurrentUser User currentUser) {
		map.put("id", id);
		dishesDailyService.update(map);
		return ResultGenerator.genSuccessResult("修改成功");
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public Result find(@RequestParam(required = false) Map<String, Object> map, Integer pageNum, Integer size) {
		Page<DishesDaily> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size);
		List<DishesDaily> findByDyna = dishesDailyService.findByDyna(map);
		return ResultGenerator.genSuccessResult(new TableData<DishesDaily>(page.getTotal(), findByDyna));
	}

	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id) {
		DishesDaily dishesDaily = dishesDailyService.findById(id);
		String breakfastFoodId = dishesDaily.getBreakfastFoodId();
		String[] breakfastFoodIds = breakfastFoodId.split(",");
		String dinnerFoodId = dishesDaily.getDinnerFoodId();
		String[] dinnerFoodIds = dinnerFoodId.split(",");
		String lunchFoodId = dishesDaily.getLunchFoodId();
		String[] lunchFoodIds = lunchFoodId.split(",");
		List<Dishes> breakfastFoods = new ArrayList<Dishes>();
		List<Dishes> dinnerFoods = new ArrayList<Dishes>();
		List<Dishes> lunchFoods = new ArrayList<Dishes>();
		for (String string : lunchFoodIds) {
			Dishes dishes = dishesService.findById(string);
			lunchFoods.add(dishes);
		}
		dishesDaily.setLunchDishes(lunchFoods);
		for (String string : breakfastFoodIds) {
			Dishes dishes = dishesService.findById(string);
			breakfastFoods.add(dishes);
		}
		dishesDaily.setBreakfastDishes(breakfastFoods);
		for (String string : dinnerFoodIds) {
			Dishes dishes = dishesService.findById(string);
			dinnerFoods.add(dishes);
		}
		dishesDaily.setDinnerDishes(dinnerFoods);
		return ResultGenerator.genSuccessResult(dishesDaily);
	}
}
