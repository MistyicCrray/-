package com.nursery_school.manager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery_school.manager.mapper.ParentsMapper;
import com.nursery_school.manager.mapper.StudentMapper;
import com.nursery_school.manager.mapper.UserMapper;
import com.nursery_school.manager.model.Parents;
import com.nursery_school.manager.model.Student;
import com.nursery_school.manager.model.User;
import com.nursery_school.manager.tools.MD5;
import com.nursery_school.manager.tools.UUIDUtils;

@Service
public class ParentService {

	@Autowired
	private ParentsMapper parentsMapper;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private StudentMapper studentMapper;

	// 添加
	public Parents add(Map<String, Object> map) {
		Parents parents = new Parents();
		User user = new User();
		parents.setId(UUIDUtils.get16UUID());
		parents.setName(map.get("name").toString());
		Map<String, Object> userM = new HashMap<String, Object>();

		userM.put("loginName", map.get("contract").toString());
		List<User> findByDymic = userMapper.findByDymic(userM);
		if (findByDymic.size() != 0) {
			return null;
		}
		parentsMapper.insert(parents);
		user.setId(UUIDUtils.get16UUID());
		user.setAddress(map.get("address").toString());
		user.setParentsId(parents.getId());
		user.setContract(map.get("contract").toString());
		user.setLoginName(map.get("contract").toString());
		user.setName(map.get("name").toString());
		user.setPassword(MD5.md5("123456"));
		user.setUserType(1);
		user.setState(0);
		userMapper.insert(user);
		return parents;
	}

	public int delete(String id) {
		Map<String, Object> map = new HashMap<>();
		map.put("parentId", id);
		userMapper.deleteByParentId(id);
		List<Student> findDyna = studentMapper.findDyna(map);
		if (findDyna.size() != 0) {
			for (Student student : findDyna) {
				studentMapper.deleteByPrimaryKey(student.getId());
			}
		}
		return parentsMapper.deleteByPrimaryKey(id);
	}

	public Map<String, Object> findParentsAnUser(String id) {
		return parentsMapper.selectUserByPid(id);
	}

	public List<Map<String, Object>> selectUserAnParents(Map<String, Object> map) {
		return parentsMapper.selectUserAnParents(map);
	}

	public List<Map<String, Object>> findParentChils(String pid) {
		return parentsMapper.findParentChils(pid);
	}

	public void update(Map<String, Object> map) {
		parentsMapper.update(map);
		map.put("id", null);
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("parentId", map.get("parentId"));
		List<User> findByDymic = userMapper.findByDymic(userMap);
		if (findByDymic.size() != 0) {
			map.put("id", findByDymic.get(0).getId());
			userMapper.updateDymic(map);
		}
	}

	public Parents findParentById(String pid) {
		return parentsMapper.selectByPrimaryKey(pid);
	}
}
