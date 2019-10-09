package com.nursery_school.manager.model.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class ReplyDynaProvider {

	public String selectProvider(Map<String, Object> map) {
		return new SQL() {
			{
				SELECT("*");
				FROM("t_reply");
				if (map != null) {
					if (map.get("id") != null) {
						WHERE("id=#{id}");
					}
					if (map.get("communuicationId") != null) {
						WHERE("communication_id=#{communuicationId}");
					}
					if (map.get("toUserId") != null) {
						WHERE("to_user_id=#{toUserId}");
					}
					if (map.get("sendUserId") != null) {
						WHERE("send_user_id=#{sendUserId}");
					}
				}
			}
		}.toString();
	}
	
	public String updateProvider(Map<String, Object> map) {
		return new SQL() {
			{
				UPDATE("t_reply");
				if (map.get("site") != null) {
					SET("site=#{site}");
				}
				if (map.get("content") != null) {
					SET("content=#{content}");
				}
				if (map.get("period") != null) {
					SET("period=#{period}");
				}
				if (map.get("standard") != null) {
					SET("standard=#{standard}");
				}
				if (map.get("time") != null) {
					SET("time=#{time}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}
}
