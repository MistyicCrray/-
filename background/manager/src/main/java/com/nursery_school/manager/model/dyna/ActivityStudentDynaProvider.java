package com.nursery_school.manager.model.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class ActivityStudentDynaProvider {

	public String selectProvider(Map<String, Object> map) {
		return new SQL() {
			{
				SELECT("*");
				FROM("t_activity_student");
				if (map != null) {
					if (map.get("id") != null) {
						WHERE("id=#{id}");
					}
					if (map.get("activityId") != null) {
						WHERE("activity_id=#{activityId}");
					}
					if (map.get("staffId") != null) {
						WHERE("staff_id=#{staffId}");
					}
					if (map.get("studentId") != null) {
						WHERE("student_id=#{studentId}");
					}
				}
			}
		}.toString();
	}
	
//	public String updateProvider(Map<String, Object> map) {
//		return new SQL() {
//			{
//				UPDATE("t_staff");
//				if (map.get("site") != null) {
//					SET("site=#{site}");
//				}
//				if (map.get("content") != null) {
//					SET("content=#{content}");
//				}
//				if (map.get("period") != null) {
//					SET("period=#{period}");
//				}
//				if (map.get("standard") != null) {
//					SET("standard=#{standard}");
//				}
//				if (map.get("time") != null) {
//					SET("time=#{time}");
//				}
//				WHERE("id=#{id}");
//			}
//		}.toString();
//	}
}
