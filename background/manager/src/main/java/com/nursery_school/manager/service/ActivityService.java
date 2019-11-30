package com.nursery_school.manager.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery_school.manager.mapper.ActivityMapper;
import com.nursery_school.manager.model.Activity;
import com.nursery_school.manager.tools.UUIDUtils;

@Service
public class ActivityService {

	@Autowired
	private ActivityMapper activityMapper;

	public void add(Activity activity) {
		activity.setId(UUIDUtils.get16UUID());
		activityMapper.insert(activity);
	}

	public void delete(String id) {
		activityMapper.deleteByPrimaryKey(id);
	}

	public void update(Map<String, Object> map) {
		activityMapper.updateProvider(map);
	}

	public Activity findById(String id) {
		Activity activity = activityMapper.selectByPrimaryKey(id);
		return activity;
	}

	public List<Activity> findList() {
		return activityMapper.selectAll();
	}

	public List<Activity> findByDyna(Map<String, Object> map) {
		return activityMapper.findByDyna(map);
	}
}
