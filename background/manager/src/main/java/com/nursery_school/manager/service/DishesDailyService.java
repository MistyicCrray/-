package com.nursery_school.manager.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery_school.manager.mapper.DishesDailyMapper;
import com.nursery_school.manager.model.DishesDaily;
import com.nursery_school.manager.tools.UUIDUtils;

@Service
public class DishesDailyService {

	@Autowired
	private DishesDailyMapper dishesDailyMapper;

	public void add(DishesDaily dishesDaily) {
		dishesDaily.setId(UUIDUtils.get16UUID());
		dishesDaily.setBreakfastMoney(dishesDaily.getBreakfastMoney() * 100);
		dishesDaily.setLunchMoney(dishesDaily.getLunchMoney() * 100);
		dishesDaily.setDinnerMoney(dishesDaily.getDinnerMoney() * 100);
		dishesDaily.setCreateDate(new Date());
		dishesDailyMapper.insert(dishesDaily);
	}

	public void delete(String id) {
		dishesDailyMapper.deleteByPrimaryKey(id);
	}

	public void update(Map<String, Object> map) {
		dishesDailyMapper.updateProvider(map);
	}

	public List<DishesDaily> findByDyna(Map<String, Object> map) {
		return dishesDailyMapper.findByDyna(map);
	}

	public DishesDaily findById(String id) {
		return dishesDailyMapper.selectByPrimaryKey(id);
	}
}
