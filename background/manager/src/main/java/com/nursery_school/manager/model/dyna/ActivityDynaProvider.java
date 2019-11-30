package com.nursery_school.manager.model.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class ActivityDynaProvider {

	public String selectProvider(Map<String, Object> map) {
		return new SQL() {
			{
				SELECT("*");
				FROM("t_activity");
				if (map != null) {
					if (map.get("id") != null) {
						WHERE("id=#{id}");
					}
					if (map.get("name") != null) {
						WHERE("name=#{name}");
					}
				}
			}
		}.toString();
	}
	
	public String updateProvider(Map<String, Object> map) {
		return new SQL() {
			{
				UPDATE("t_activity");
				if (map.get("name") != null) {
					SET("name=#{name}");
				}
				if (map.get("detail") != null) {
					SET("detail=#{detail}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}
}
