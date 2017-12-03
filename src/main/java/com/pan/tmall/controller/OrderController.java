package com.pan.tmall.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pan.tmall.pojo.Order;
import com.pan.tmall.service.OrderItemService;
import com.pan.tmall.service.OrderService;

@Controller
@RequestMapping(value = { "/order/" })
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderItemService orderItemService;

	@RequestMapping(value = "list", method = GET)
	public String list(@RequestParam(value = "start", defaultValue = "0") int start, Model model) {
		PageHelper.offsetPage(start, 10);
		List<Order> orders = orderService.list();
		PageInfo page = new PageInfo<>(orders);
		orderItemService.fill(orders);
		
		model.addAttribute("orders", orders);
		model.addAttribute("page", page);
		model.addAttribute("uri", "order/list");
		return "admin/listOrders";
	}
	@RequestMapping(value= {"delivery"},method=GET)
	public String delivery(Order order) {
		orderService.delivery(order);
		
		return "redirect:list";
		
	}
	
	
}
