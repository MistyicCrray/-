package com.nursery_school.manager.model.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.nursery_school.manager.tools.MD5;

public class UserDynaProvider {
	public String selectProvider(Map<String, Object> map) {
		return new SQL() {
			{
				SELECT("*");
				FROM("t_user");
				if (map != null) {
					if (map.get("id") != null) {
						WHERE("id=#{id}");
					}
					if (map.get("loginName") != null) {
						WHERE("login_name=#{loginName}");
					}
					if (map.get("state") != null) {
						WHERE("state=#{state}");
					}
					if (map.get("userType") != null) {
						WHERE("user_type=#{userType}");
					}
					if (map.get("parentId") != null) {
						WHERE("parent_id=#{parentId}");
					}
					if (map.get("staffId") != null) {
						WHERE("staff_id=#{staffId}");
					}
					if (map.get("userType") != null) {
						WHERE("user_type=#{userType}");
					}
				}
			}
		}.toString();
	}

	public String updateProvider(Map<String, Object> map) {
		return new SQL() {
			{
				UPDATE("t_user");
				if (map.get("contract") != null) {
					SET("contract=#{contract}");
				}
				if (map.get("password") != null) {
					map.put("password", MD5.md5(map.get("password").toString()));
					SET("password=#{password}");
				}
				if (map.get("address") != null) {
					SET("address=#{address}");
				}
				if (map.get("userType") != null) {
					SET("user_type=#{userType}");
				}
				if (map.get("state") != null) {
					SET("state=#{state}");
				}
				if (map.get("birthday") != null) {
					SET("birthday=#{birthday}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}
}
