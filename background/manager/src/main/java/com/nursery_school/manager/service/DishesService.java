package com.nursery_school.manager.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery_school.manager.mapper.DishesMapper;
import com.nursery_school.manager.model.Dishes;
import com.nursery_school.manager.tools.UUIDUtils;

@Service
public class DishesService {

	@Autowired
	private DishesMapper dishesMapper;

	public void add(Dishes dishes) {
		dishes.setId(UUIDUtils.get16UUID());
		dishesMapper.insert(dishes);
	}

	public void delete(String id) {
		dishesMapper.deleteByPrimaryKey(id);
	}

	public void update(Map<String, Object> map) {
		dishesMapper.updateProvider(map);
	}

	public List<Dishes> findByDyna(Map<String, Object> map) {
		return dishesMapper.findByDyna(map);
	}

	public Dishes findById(String id) {
		return dishesMapper.selectByPrimaryKey(id);
	}
}
