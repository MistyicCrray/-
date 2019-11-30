package com.nursery_school.manager.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery_school.manager.mapper.ProjectMapper;
import com.nursery_school.manager.model.Project;
import com.nursery_school.manager.tools.UUIDUtils;

@Service
public class ProjectService {

	@Autowired
	private ProjectMapper projectMapper;

	public void add(Project project) {
		project.setId(UUIDUtils.get16UUID());
		projectMapper.insert(project);
	}

	public void delete(String id) {
		projectMapper.deleteByPrimaryKey(id);
	}

	public void update(Map<String, Object> map) {
		projectMapper.updateProvider(map);;
	}

	public Project findById(String id) {
		Project project = projectMapper.selectByPrimaryKey(id);
		return project;
	}

	public List<Project> findList() {
		return projectMapper.selectAll();
	}
	
	public List<Project> findByDyna(Map<String, Object> map) {
		return projectMapper.findByDyna(map);
	}
}
