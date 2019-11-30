package com.nursery_school.manager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery_school.manager.mapper.ActivityMapper;
import com.nursery_school.manager.mapper.ActivityStudentMapper;
import com.nursery_school.manager.mapper.StaffMapper;
import com.nursery_school.manager.mapper.StudentMapper;
import com.nursery_school.manager.mapper.UserMapper;
import com.nursery_school.manager.model.Activity;
import com.nursery_school.manager.model.ActivityStudent;
import com.nursery_school.manager.model.Staff;
import com.nursery_school.manager.model.Student;
import com.nursery_school.manager.model.User;
import com.nursery_school.manager.tools.UUIDUtils;

@Service
public class ActivityStudentService {

	@Autowired
	private ActivityStudentMapper activityStudentMapper;
	@Autowired
	private ActivityMapper activityMapper;
	@Autowired
	private StaffMapper staffMapper;
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private UserMapper userMapper;

	public void add(Map<String, Object> map) {
		ActivityStudent activityStudent = new ActivityStudent();
		activityStudent.setId(UUIDUtils.get16UUID());
		activityStudent.setActivityId(map.get("activityId").toString());
		activityStudent.setStudentId(map.get("studentId").toString());
		activityStudent.setStaffId(map.get("staffId").toString());
		activityStudentMapper.insert(activityStudent);
	}

	public void delete(String id) {
		activityStudentMapper.deleteByPrimaryKey(id);
	}

	public ActivityStudent findById(String id) {
		ActivityStudent project = activityStudentMapper.selectByPrimaryKey(id);
		return project;
	}

	public List<ActivityStudent> findList() {
		return activityStudentMapper.selectAll();
	}

	public List<ActivityStudent> findByDyna(Map<String, Object> map) {
		List<ActivityStudent> findByDyna = activityStudentMapper.findByDyna(map);
		for (ActivityStudent activityStudent : findByDyna) {
			Activity activity = activityMapper.selectByPrimaryKey(activityStudent.getActivityId());
			activityStudent.setActivity(activity);
			Staff staff = staffMapper.selectByPrimaryKey(activityStudent.getStaffId());
			Map<String, Object> userMap = new HashMap<String, Object>();
			userMap.put("staffId", staff.getId());
			List<User> user = userMapper.findByDymic(userMap);
			staff.setUser(user.get(0));
			activityStudent.setStaff(staff);
			Student student = studentMapper.selectByPrimaryKey(activityStudent.getStudentId());
			activityStudent.setStudent(student);
		}
		return findByDyna;
	}
}
