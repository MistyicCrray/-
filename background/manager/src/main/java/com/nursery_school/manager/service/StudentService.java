package com.nursery_school.manager.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery_school.manager.mapper.StudentMapper;
import com.nursery_school.manager.model.Student;
import com.nursery_school.manager.tools.UUIDUtils;

@Service
public class StudentService {

	@Autowired
	private StudentMapper studentMapper;

	public List<Student> findByDyna(Map<String, Object> map) {
		return studentMapper.findDyna(map);
	}

	public void addStudent(Student student) {
		student.setId(UUIDUtils.get16UUID());
		studentMapper.insert(student);
	}
	
	public void update(Map<String, Object> map) {
		studentMapper.updateProvider(map);
	}
	
	public Student findById(String id) {
		return studentMapper.selectByPrimaryKey(id);
	}
	
}
