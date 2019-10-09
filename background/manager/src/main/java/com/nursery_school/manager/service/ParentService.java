package com.nursery_school.manager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery_school.manager.mapper.ParentsMapper;
import com.nursery_school.manager.mapper.UserMapper;
import com.nursery_school.manager.model.Parents;
import com.nursery_school.manager.model.User;
import com.nursery_school.manager.tools.MD5;
import com.nursery_school.manager.tools.UUIDUtils;

@Service
public class ParentService {

	@Autowired
	private ParentsMapper parentsMapper;

	@Autowired
	private UserMapper userMapper;

	// 添加
	public Parents add(Map<String, Object> map) {
		Parents parents = new Parents();
		User user = new User();
		parents.setId(UUIDUtils.get16UUID());
		parents.setName(map.get("name").toString());
		Map<String, Object> userM = new HashMap<String, Object>();
		
		userM.put("loginName", map.get("contract").toString());
		List<User> findByDymic = userMapper.findByDymic(userM);
		if(findByDymic.size() != 0) {
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
		List<User> findByDymic = userMapper.findByDymic(map);
		if (findByDymic.size() != 0) {
			map.put("id", findByDymic.get(0).getId());
			userMapper.updateDymic(map);
		}
	}
	
	public Parents findParentById(String pid) {
		return parentsMapper.selectByPrimaryKey(pid);
	}

}
