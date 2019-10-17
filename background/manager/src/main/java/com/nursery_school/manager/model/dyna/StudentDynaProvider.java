package com.nursery_school.manager.model.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class StudentDynaProvider {
	public String selectProvider(Map<String, Object> map) {
		return new SQL() {
			{
				SELECT("*");
				FROM("t_student");
				if (map != null) {
					if (map.get("id") != null) {
						WHERE("id=#{id}");
					}
					if (map.get("name") != null) {
						WHERE("name like '%" + map.get("name") + "%' or contract like '%" + map.get("contract") + "%'");
					}
					if (map.get("parentId") != null) {
						WHERE("parent_id=#{parentId}");
					}
				}
			}
		}.toString();
	}

	public String updateProvider(Map<String, Object> map) {
		return new SQL() {
			{
				UPDATE("t_student");
				if (map.get("name") != null) {
					SET("name=#{name}");
				}
				if (map.get("contract") != null) {
					SET("contract=#{contract}");
				}
				if (map.get("address") != null) {
					SET("address=#{address}");
				}
				if (map.get("inDate") != null) {
					SET("in_date=#{inDate}");
				}
				if (map.get("fatherTel") != null) {
					SET("father_tel=#{fatherTel}");
				}
				if (map.get("matherTel") != null) {
					SET("mather_tel=#{matherTel}");
				}
				if (map.get("fatherName") != null) {
					SET("father_name=#{fatherName}");
				}
				if (map.get("matherName") != null) {
					SET("mather_name=#{matherName}");
				}
				if (map.get("classId") != null) {
					SET("class_id=#{classId}");
				}
				if (map.get("gender") != null) {
					SET("gender=#{gender}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}
}
