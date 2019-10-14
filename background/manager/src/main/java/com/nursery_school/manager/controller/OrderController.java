package com.nursery_school.manager.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nursery_school.manager.model.Order;
import com.nursery_school.manager.model.Parents;
import com.nursery_school.manager.model.PayStandard;
import com.nursery_school.manager.model.Student;
import com.nursery_school.manager.model.User;
import com.nursery_school.manager.service.OrderService;
import com.nursery_school.manager.service.ParentService;
import com.nursery_school.manager.service.PayStandardService;
import com.nursery_school.manager.service.StudentService;
import com.nursery_school.manager.tools.CurrentUser;
import com.nursery_school.manager.tools.LoginRequired;
import com.nursery_school.manager.tools.Result;
import com.nursery_school.manager.tools.ResultGenerator;
import com.nursery_school.manager.tools.TableData;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private PayStandardService payStandardService;

	@Autowired
	private ParentService parentService;

	/**
	 * 点击去付款
	 * 
	 * @param order
	 * @param currentUser
	 * @return
	 */
	@LoginRequired(value = "1")
	@RequestMapping(value = "/goToPay", method = RequestMethod.POST)
	public Result goToPay(@RequestBody Map<String, Object> map, @CurrentUser User currentUser) {
		map.put("parentId", currentUser.getParentsId());
		return ResultGenerator.genSuccessResult(orderService.add(map));
	}

	/**
	 * 家长查询的缴费信息
	 * 
	 * @param map
	 * @param pageNum
	 * @param size
	 * @param currentUser
	 * @return
	 */
	@LoginRequired(value = "1")
	@RequestMapping(value = "/findOrderByParent", method = RequestMethod.GET)
	public Result findOrderByParent(@RequestParam(required = false) Map<String, Object> map, Integer pageNum,
			Integer size, @CurrentUser User currentUser) {
		Page<Order> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size);
		String parentsId = currentUser.getParentsId();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 得到所有收费标准信息
		List<PayStandard> findAll = payStandardService.selectProvider(map);
		List<Order> resMap = new ArrayList<Order>();
		if (parentsId != null) {
			Map<String, Object> stMap = new HashMap<String, Object>();
			stMap.put("parentId", parentsId);
			// 查找家长
			List<Student> students = studentService.findByDyna(stMap);
			if (students.size() != 0) {
				for (Student student : students) {
					Map<String, Object> orMap = new HashMap<String, Object>();
					orMap.put("studentId", student.getId());
					// 得到该家长孩子的收费信息
//					List<Order> orders = orderService.findByDyna(orMap);
					// 如果已经有收费信息循环
//					if (orders.size() != 0) {
						// for (Order order : orders) {
						// order.setStudent(student);
						// PayStandard findById =
						// payStandardService.findById(order.getPayStandardId());
						// order.setPayStandard(findById);
						// resMap.add(order);
						for (PayStandard payStandard : findAll) {
							Map<String, Object> newOrderMap = new HashMap<String, Object>();
							newOrderMap.put("studentId", student.getId());
							newOrderMap.put("payStandardId", payStandard.getId());
							List<Order> findByDyna = orderService.findByDyna(newOrderMap);
							Order newOrder = new Order();
							if (findByDyna.size() != 0) {
								newOrder = findByDyna.get(0);
								newOrder.setStudent(student);
								newOrder.setPayStandard(payStandard);
							} else {
								newOrder.setState(0);
								newOrder.setStudent(student);
								newOrder.setPayStandard(payStandard);
							}
							
							resMap.add(newOrder);
							// }
						}
//					} else { // 没有收费信息时将收费标准列出来
//						for (PayStandard payStandard : findAll) {
//							Order order = new Order();
//							order.setStudent(student);
//							order.setState(0);
//							order.setPayStandard(payStandard);
//							resMap.add(order);
//						}
//					}
				}
			}
		}
		return ResultGenerator.genSuccessResult(new TableData<Order>(page.getTotal(), resMap));
	}

	@LoginRequired(value = "1")
	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable(value = "id") String id) {
		Order order = orderService.findById(id);
		Map<String, Object> stuMap = new HashMap<String, Object>();
		stuMap.put("id", order.getStudentId());
		List<Student> students = studentService.findByDyna(stuMap);
		Student student = students.get(0);
		order.setStudent(student);

		PayStandard payStandard = payStandardService.findById(order.getPayStandardId());
		order.setPayStandard(payStandard);
		return ResultGenerator.genSuccessResult(order);
	}

	/**
	 * 园长查询
	 * 
	 * @param map
	 * @param pageNum
	 * @param size
	 * @param currentUser
	 * @return
	 */
	@LoginRequired(value = "3")
	@RequestMapping(value = "/findOrderByLeader", method = RequestMethod.GET)
	public Result findOrderByLeader(@RequestParam(required = false) Map<String, Object> map, Integer pageNum,
			Integer size, @CurrentUser User currentUser) {
		Page<Order> page = PageHelper.startPage(pageNum == null ? 1 : pageNum, size == null ? 5 : size);
		List<Order> orders = orderService.findByDyna(map);
		for (Order order : orders) {
			Student student = studentService.findById(order.getStudentId());
			order.setStudent(student);
			Parents parent = parentService.findParentById(order.getParentId());
			order.setParents(parent);
			PayStandard payStandard = payStandardService.findById(order.getPayStandardId());
			order.setPayStandard(payStandard);
		}
		return ResultGenerator.genSuccessResult(new TableData<Order>(page.getTotal(), orders));
	}
}
