package com.nursery_school.manager.model.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class CommunicationDynaProvider {

	public String selectProvider(Map<String, Object> map) {
		return new SQL() {
			{
				SELECT("*");
				FROM("t_communication");
				if (map != null) {
					if (map.get("id") != null) {
						WHERE("id=#{id}");
					}
					if (map.get("userId") != null) {
						WHERE("user_id=#{userId} or to_user_id=#{userId}");
					}
					if (map.get("toUserId") != null) {
						WHERE("to_user_id=#{toUserId}");
					}
				}
			}
		}.toString();
	}
	
	public String updateProvider(Map<String, Object> map) {
		return new SQL() {
			{
				UPDATE("t_communication");
				if (map.get("title") != null) {
					SET("title=#{title}");
				}
				if (map.get("content") != null) {
					SET("content=#{content}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}
}
