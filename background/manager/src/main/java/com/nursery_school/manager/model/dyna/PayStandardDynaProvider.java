package com.nursery_school.manager.model.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class PayStandardDynaProvider {
	public String selectProvider(Map<String, Object> map) {
		return new SQL() {
			{
				SELECT("*");
				FROM("t_pay_standard");
				if (map != null) {
					if (map.get("year") != null) {
						WHERE("year=STR_TO_DATE(#{year},'%Y-%m-%d')");
					}
				}
			}
		}.toString();
	}

	public String updateProvider(Map<String, Object> map) {
		return new SQL() {
			{
				UPDATE("t_pay_standard");
				if (map.get("schooling") != null) {
					map.put("schooling", Integer.parseInt(map.get("schooling").toString())*100);
					SET("schooling=#{schooling}");
				}
				if (map.get("bookMoney") != null) {
					map.put("bookMoney", Integer.parseInt(map.get("bookMoney").toString())*100);
					SET("book_money=#{bookMoney}");
				}
				if (map.get("boardAges") != null) {
					map.put("boardAges", Integer.parseInt(map.get("boardAges").toString())*100);
					SET("board_ages=#{boardAges}");
				}
				if (map.get("quarterage") != null) {
					map.put("quarterage", Integer.parseInt(map.get("quarterage").toString())*100);
					SET("quarterage=#{quarterage}");
				}
				if (map.get("paymentDeadline") != null) {
					SET("payment_deadline=#{paymentDeadline}");
				}
				if (map.get("year") != null) {
					SET("year=#{year}");
				}
				if (map.get("file") != null) {
					SET("file=#{file}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}
}
