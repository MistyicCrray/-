package com.nursery_school.manager.model.dyna;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class DishesDailyDynaProvider {

	public String selectProvider(Map<String, Object> map) {
		return new SQL() {
			{
				SELECT("*");
				FROM("t_dishes_daily");
				if (map != null) {
					if (map.get("dishesDate") != null) {
						WHERE("dishes_date=#{dishesDate}");
					}
				}
			}
		}.toString();
	}

	public String updateProvider(Map<String, Object> map) {
		return new SQL() {
			{
				UPDATE("t_dishes_daily");
				if (map.get("breakfastFood") != null) {
					SET("breakfast_food=#{breakfastFood}");
				}
				if (map.get("breakfastMoney") != null) {
					SET("breakfast_money=#{breakfastMoney}");
				}
				if (map.get("lunchFood") != null) {
					SET("lunch_food=#{lunchFood}");
				}
				if (map.get("lunchMoney") != null) {
					SET("lunch_money=#{lunchMoney}");
				}
				if (map.get("dinnerFood") != null) {
					SET("dinner_food=#{dinnerFood}");
				}
				if (map.get("dinnerMoney") != null) {
					SET("dinner_money=#{dinnerMoney}");
				}
				if (map.get("dishesDate") != null) {
					SET("dishes_date=#{dishesDate}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}

}
