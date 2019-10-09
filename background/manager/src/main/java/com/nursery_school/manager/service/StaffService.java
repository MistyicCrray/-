package com.nursery_school.manager.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery_school.manager.mapper.StaffMapper;
import com.nursery_school.manager.mapper.UserMapper;
import com.nursery_school.manager.model.Staff;
import com.nursery_school.manager.model.User;
import com.nursery_school.manager.tools.MD5;
import com.nursery_school.manager.tools.UUIDUtils;

@Service
public class StaffService {

	@Autowired
	private StaffMapper staffMapper;
	@Autowired
	private UserMapper userMapper;

	public Staff add(Map<String, Object> map) {
		Staff staff = new Staff();
		staff.setId(UUIDUtils.get16UUID());
		staff.setWorkNumber(UUIDUtils.getOrderIdByTime());
		Map<String, Object> userM = new HashMap<String, Object>();

		userM.put("loginName", map.get("contract").toString());
		List<User> findByDymic = userMapper.findByDymic(userM);
		if (findByDymic.size() != 0) {
			return null;
		}
		User user = new User();
		user.setId(UUIDUtils.get16UUID());
		user.setAddress(map.get("address").toString());
		user.setStaffId(staff.getId());
		user.setContract(map.get("contract").toString());
		user.setLoginName(map.get("contract").toString());
		user.setName(map.get("name").toString());
		user.setPassword(MD5.md5("123456"));
		if (map.get("gender") != null) {
			user.setGender(Integer.parseInt(map.get("gender").toString()));
		}
		user.setUserType(Integer.parseInt(map.get("userType").toString()));
		user.setState(0);
		staffMapper.insert(staff);
		userMapper.insert(user);
		return staff;
	}

	public void delete(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("staffId", id);
		List<User> findByDymic = userMapper.findByDymic(map);
		if (findByDymic.size() != 0) {
			userMapper.deleteByPrimaryKey(findByDymic.get(0).getId());
		}
		staffMapper.deleteByPrimaryKey(id);
	}

	public void update(Map<String, Object> map) {
		map.put("id", map.get("userId"));
		userMapper.updateDymic(map);
	}

	public List<Staff> findByDyna(Map<String, Object> map) {
		List<Staff> findByDyna = staffMapper.findByDyna(map);
		for (Staff staff : findByDyna) {
			Map<String, Object> usermap = new HashMap<>();
			usermap.put("staffId", staff.getId());
			List<User> findByDymic = userMapper.findByDymic(usermap);
			if (findByDymic.size() != 0) {
				staff.setUser(findByDymic.get(0));
			}
		}
		return findByDyna;
	}

	public Staff findById(String id) {
		return staffMapper.selectByPrimaryKey(id);
	}

}
