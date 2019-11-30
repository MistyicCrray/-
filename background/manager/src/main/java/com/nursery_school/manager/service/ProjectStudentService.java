package com.nursery_school.manager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery_school.manager.mapper.ProjectMapper;
import com.nursery_school.manager.mapper.ProjectStudentMapper;
import com.nursery_school.manager.mapper.StaffMapper;
import com.nursery_school.manager.mapper.StudentMapper;
import com.nursery_school.manager.mapper.UserMapper;
import com.nursery_school.manager.model.Project;
import com.nursery_school.manager.model.ProjectStudent;
import com.nursery_school.manager.model.Staff;
import com.nursery_school.manager.model.Student;
import com.nursery_school.manager.model.User;
import com.nursery_school.manager.tools.UUIDUtils;

@Service
public class ProjectStudentService {

	@Autowired
	private ProjectStudentMapper projectStudentMapper;
	@Autowired
	private ProjectMapper projectMapper;
	@Autowired
	private StaffMapper staffMapper;
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private UserMapper userMapper;

	public void add(Map<String, Object> map) {
		ProjectStudent projectStudent = new ProjectStudent();
		projectStudent.setProjectId(map.get("projectId").toString());
		projectStudent.setStudentId(map.get("studentId").toString());
		projectStudent.setTeacherId(map.get("teacherId").toString());
		projectStudent.setId(UUIDUtils.get16UUID());
		projectStudentMapper.insert(projectStudent);
	}

	public void delete(String id) {
		projectStudentMapper.deleteByPrimaryKey(id);
	}

	public void update(ProjectStudent projectStudent) {
		projectStudentMapper.updateByPrimaryKey(projectStudent);
	}

	public ProjectStudent findById(String id) {
		ProjectStudent projectStudent = projectStudentMapper.selectByPrimaryKey(id);
		return projectStudent;
	}

	public List<ProjectStudent> findList() {
		return projectStudentMapper.selectAll();
	}

	public List<ProjectStudent> findByDyna(Map<String, Object> map) {
		List<ProjectStudent> findByDyna = projectStudentMapper.findByDyna(map);
		for (ProjectStudent projectStudent : findByDyna) {
			Project project = projectMapper.selectByPrimaryKey(projectStudent.getProjectId());
			projectStudent.setProject(project);
			Staff staff = staffMapper.selectByPrimaryKey(projectStudent.getTeacherId());
			projectStudent.setStaff(staff);
			Student student = studentMapper.selectByPrimaryKey(projectStudent.getStudentId());
			Map<String, Object> userMap = new HashMap<String, Object>();
			userMap.put("staffId", staff.getId());
			User user = userMapper.findByDymic(userMap).get(0);
			staff.setUser(user);
			projectStudent.setStudent(student);
		}
		return findByDyna;
	}

}
