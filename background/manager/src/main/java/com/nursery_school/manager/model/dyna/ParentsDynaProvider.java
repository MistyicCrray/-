package com.nursery_school.manager.model.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class ParentsDynaProvider {
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
						WHERE("login_name like '%" + map.get("loginName") + "%'");
					}
					if (map.get("state") != null) {
						WHERE("state=#{state}");
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
				UPDATE("t_parents");
				if (map.get("name") != null) {
					SET("name=#{name}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}

	public String selectUserByPid(String parentsId) {
		return new SQL() {
			{
				SELECT("tp.id as p_id,tp.name as p_name,tu.*");
				FROM("t_user tu");
				LEFT_OUTER_JOIN(" t_parents tp ON tu.parents_id=tp.id");
				WHERE("tp.id=#{parentsId}");
			}
		}.toString();
	}

	public String selectUserAnParents(Map<String, Object> map) {
		return new SQL() {
			{
				SELECT("tp.id as p_id,tp.name as p_name,tu.id as u_id,tu.name as u_name,tu.login_name as u_loginName"
						+ ",tu.contract as u_contract,tu.birthday as u_birthday,tu.address as u_address,"
						+ "tu.gender as u_gender,tu.user_type as u_userType,tu.parents_id as u_parentsId");
				FROM("t_user tu");
				LEFT_OUTER_JOIN("t_parents tp ON tu.parents_id=tp.id");
				WHERE("tu.user_type=1");
				if (map.get("name") != null || map.get("contract") != null) {
					WHERE("tp.name=#{name} or tu.contract=#{contract}");
				}
			}
		}.toString();
	}
}
