package com.nursery_school.manager.model.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class CleaningInfoDynaProvider {

	public String selectProvider(Map<String, Object> map) {
		return new SQL() {
			{
				SELECT("*");
				FROM("t_cleaning_info");
				if (map != null) {
					if (map.get("id") != null) {
						WHERE("id=#{id}");
					}
					if (map.get("cleaningId") != null) {
						WHERE("cleaning_id=#{cleaningId}");
					}
				}
			}
		}.toString();
	}
	
	public String updateProvider(Map<String, Object> map) {
		return new SQL() {
			{
				UPDATE("t_cleaning_info");
				if (map.get("clean_start_time") != null) {
					SET("clean_start_time=#{clean_start_time}");
				}
				if (map.get("cleanEndTime") != null) {
					SET("clean_end_time=#{cleanEndTime}");
				}
				if (map.get("img") != null) {
					SET("img=#{img}");
				}
				if (map.get("staffId") != null) {
					SET("staff_id=#{staffId}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}
}
