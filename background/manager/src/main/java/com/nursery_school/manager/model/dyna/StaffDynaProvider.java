package com.nursery_school.manager.model.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class StaffDynaProvider {

	public String selectProvider(Map<String, Object> map) {
		return new SQL() {
			{
				SELECT("*");
				FROM("t_staff");
				if (map != null) {
					if (map.get("id") != null) {
						WHERE("id=#{id}");
					}
					if (map.get("workNumber") != null) {
						WHERE("work_number=#{workNumber}");
					}
					if (map.get("idCard") != null) {
						WHERE("id_card=#{idCard}");
					}
				}
			}
		}.toString();
	}
	
	public String updateProvider(Map<String, Object> map) {
		return new SQL() {
			{
				UPDATE("t_staff");
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
