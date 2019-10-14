package com.nursery_school.manager.model.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class OrderDynaProvider {

	public String selectProvider(Map<String, Object> map) {
		return new SQL() {
			{
				SELECT("*");
				FROM("t_order");
				if (map != null) {
					if (map.get("id") != null) {
						WHERE("id=#{id}");
					}
					if (map.get("parentId") != null) {
						WHERE("parent_id=#{parentId}");
					}
					if (map.get("studentId") != null) {
						WHERE("student_id=#{studentId}");
					}
					if (map.get("payStandardId") != null) {
						WHERE("pay_standard_id=#{payStandardId}");
					}
				}
			}
		}.toString();
	}

	public String updateProvider(Map<String, Object> map) {
		return new SQL() {
			{
				UPDATE("t_order");
				if (map.get("state") != null) {
					SET("state=#{state}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}
}
