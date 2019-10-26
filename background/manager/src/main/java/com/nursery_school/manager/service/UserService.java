package com.nursery_school.manager.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery_school.manager.mapper.ParentsMapper;
import com.nursery_school.manager.mapper.StaffMapper;
import com.nursery_school.manager.mapper.UserMapper;
import com.nursery_school.manager.model.Parents;
import com.nursery_school.manager.model.Staff;
import com.nursery_school.manager.model.User;
import com.nursery_school.manager.tools.MD5;
import com.nursery_school.manager.tools.TokenUtil;
import com.nursery_school.manager.tools.UUIDUtils;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ParentsMapper parentsMapper;
	@Autowired
	private StaffMapper staffMapper;

	public void addUser(User user) {
		user.setId(UUIDUtils.get16UUID());
		user.setCreateTime(new Date());
		user.setPassword(MD5.md5(user.getPassword()));
		user.setState(0);

		// 用户类型为家长则添加一条信息到家长表
		if (user.getUserType().equals(1)) {
			Parents parents = new Parents();
			parents.setId(UUIDUtils.get16UUID());
			parents.setName(user.getName());
			parentsMapper.insert(parents);
		}
		// 教职工添加
		if (user.getUserType() >= 2) {
			Staff staff = new Staff();
			staff.setId(UUIDUtils.get16UUID());
			staff.setWorkNumber(UUIDUtils.getOrderIdByTime());
			staffMapper.insert(staff);
		}

		userMapper.insert(user);
	}

	public User findById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	/**
	 * 登录
	 * 
	 * @Title: login
	 * @Description: TODO
	 * @param map
	 * @return Map<String,Object>
	 */
	public Map<String, Object> login(User user) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		user.setPassword(MD5.md5(user.getPassword()));
		User users = userMapper.findByLoginNameAndPassword(user);
		if (users == null) {
			return null;
		}
		String token = TokenUtil.createJwtToken(users.getId());// 存入token
		resultMap.put("userInfo", users); // 存入user信息
		resultMap.put("accessToken", token);
		return resultMap;
	}

	public List<User> findUserAll() {
		return userMapper.selectAll();
	}

	public List<User> findDymic(Map<String, Object> map) {
		return userMapper.findByDymic(map);
	}

	public User findByLoginName(String loginName) {
		Map<String, Object> map = new HashMap<>();
		map.put("loginName", loginName);
		List<User> users = userMapper.findByDymic(map);
		if (users.size() == 0) {
			return null;
		}
		return users.get(0);
	}

	public void deleteUser(String id) {
		userMapper.deleteByPrimaryKey(id);
	}

	public void updateDymic(Map<String, Object> map) {
		userMapper.updateDymic(map);
	}

	public void updatePwd(String password, User user) {
		user.setPassword(MD5.md5(password));
		userMapper.updateByPrimaryKey(user);
	}

}
