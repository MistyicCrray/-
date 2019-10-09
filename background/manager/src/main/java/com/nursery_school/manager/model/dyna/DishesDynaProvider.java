package com.nursery_school.manager.model.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class DishesDynaProvider {

	public String selectProvider(Map<String, Object> map) {
		return new SQL() {
			{
				SELECT("*");
				FROM("t_dishes");
				if (map != null) {
					if (map.get("id") != null) {
						WHERE("id=#{id}");
					}
					if (map.get("name") != null) {
						WHERE("name like '%" + map.get("name") + "%'");
					}
					if (map.get("ingredients") != null) {
						WHERE("ingredients=#{ingredients}");
					}
				}
			}
		}.toString();
	}

	public String updateProvider(Map<String, Object> map) {
		return new SQL() {
			{
				UPDATE("t_dishes");
				if (map.get("name") != null) {
					SET("name=#{name}");
				}
				if (map.get("ingredients") != null) {
					SET("ingredients=#{ingredients}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}
}
