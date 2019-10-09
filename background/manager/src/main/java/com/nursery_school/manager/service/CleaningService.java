package com.nursery_school.manager.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery_school.manager.mapper.CleaningMapper;
import com.nursery_school.manager.model.Cleaning;
import com.nursery_school.manager.tools.UUIDUtils;

@Service
public class CleaningService {

	@Autowired
	private CleaningMapper cleaningMapper;

	public void add(Cleaning cleaning) {
		cleaning.setId(UUIDUtils.get16UUID());
		cleaningMapper.insert(cleaning);
	}

	public void delete(String id) {
		cleaningMapper.deleteByPrimaryKey(id);
	}

	public void update(Map<String, Object> map) {
		cleaningMapper.updateProvider(map);
	}

	public List<Cleaning> findByDyna(Map<String, Object> map) {
		return cleaningMapper.findByDyna(map);
	}

	public Cleaning findById(String id) {
		return cleaningMapper.selectByPrimaryKey(id);
	}
}
