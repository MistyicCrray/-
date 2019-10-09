package com.nursery_school.manager.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nursery_school.manager.mapper.OrderMapper;
import com.nursery_school.manager.mapper.PayStandardMapper;
import com.nursery_school.manager.model.Order;
import com.nursery_school.manager.model.PayStandard;
import com.nursery_school.manager.tools.UUIDUtils;

@Service
public class OrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private PayStandardMapper payStandardMapper;
	
	public Order add(Map<String, Object> map) {
		Order order = new Order();
		PayStandard payMoney = payStandardMapper.selectByPrimaryKey(map.get("payStandardId").toString());
		order.setId(UUIDUtils.get16UUID());
		order.setPayMoney(payMoney.getBoardAges() + payMoney.getBookMoney() + payMoney.getQuarterage() + payMoney.getSchooling());
		order.setPayStandardId(payMoney.getId());
		order.setParentId(map.get("parentId").toString());
		order.setCreateDate(new Date());
		order.setState(0);
		order.setStudentId(map.get("studentId").toString());
		order.setPayMode("aplipay");
		orderMapper.insert(order);
		return order;
	}
	
	public void delete(String id) {
		orderMapper.deleteByPrimaryKey(id);
	}
	
	public void update(Order order) {
		orderMapper.updateByPrimaryKey(order);
	}
	
	public List<Order> findByDyna(Map<String, Object> map) {
		List<Order> findByDyna = orderMapper.findByDyna(map);
		return findByDyna;
	}
	
	public Order findById(String id) {
		return orderMapper.selectByPrimaryKey(id);
	}
}
