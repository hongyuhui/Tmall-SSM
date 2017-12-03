package com.pan.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pan.tmall.mapper.OrderMapper;
import com.pan.tmall.pojo.Order;
import com.pan.tmall.pojo.OrderExample;
import com.pan.tmall.pojo.OrderExample.Criteria;
import com.pan.tmall.pojo.Orderitem;
import com.pan.tmall.pojo.User;
import com.pan.tmall.service.OrderItemService;
import com.pan.tmall.service.OrderService;
import com.pan.tmall.service.ReviewService;
import com.pan.tmall.service.UserService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderItemService orderItemService;
	@Autowired
	private UserService userService;
	@Autowired
	private ReviewService reviewService;

	@Override
	public Order get(int oid) {
		return orderMapper.selectByPrimaryKey(oid);
	}

	// 创建订单并将订单编号绑定到订单项
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
	public float add(Order order, List<Orderitem> orderitems) {
		float total = 0f;
		orderMapper.insert(order);

		for (Orderitem orderitem : orderitems) {
			orderitem.setOid(order.getId());
			orderItemService.update(orderitem);
			total += orderitem.getNumber() * orderitem.getProduct().getPromoteprice();
		}
		return total;
	}

	// 删除订单
	@Override
	public void delete(Order order) {
		order.setStatus(OrderService.delete);
		orderMapper.updateByPrimaryKeySelective(order);
	}

	@Override
	public void edit(int orderId) {

	}

	@Override
	public void update(Order order) {
		orderMapper.updateByPrimaryKeySelective(order);
	}

	@Override
	public List<Order> list() {
		OrderExample example = new OrderExample();
		example.setOrderByClause("id DESC");
		List<Order> orders = orderMapper.selectByExample(example);
		setUser(orders);

		orderItemService.fill(orders);
		return orders;
	}

	@Override
	public void setUser(Order order) {
		User user = userService.get(order.getUid());
		order.setUser(user);

	}

	@Override
	public void setUser(List<Order> orders) {
		for (Order order : orders) {
			setUser(order);
		}

	}

	// 发货
	@Override
	public void delivery(Order order) {
		order.setStatus(OrderService.waitConfirm);
		orderMapper.updateByPrimaryKeySelective(order);

	}

	@Override
	public List<Order> listByUser(User user) {
		OrderExample example = new OrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andUidEqualTo(user.getId());
		criteria.andStatusNotEqualTo("delete");
		return orderMapper.selectByExample(example);
	}

	@Override
	public void setOrderItem(Order order) {
		List<Orderitem> orderItems = orderItemService.listByOrder(order);
		order.setOrderItems(orderItems);
	}

	@Override
	public void setOrderItem(List<Order> orders) {
		for (Order order : orders) {
			setOrderItem(order);
		}

	}

	@Override
	public void setTotalMoneyAndProductNumber(Order order) {
		List<Orderitem> orderitems = order.getOrderItems();
		float total = 0;
		int totalNumber = 0;
		for (Orderitem orderitem : orderitems) {
			total += orderitem.getNumber() * orderitem.getProduct().getPromoteprice();
		}
		order.setTotal(total);
		order.setTotalNumber(totalNumber);
	}

	@Override
	public void setTotalMoneyAndProductNumber(List<Order> orders) {
		for (Order order : orders) {
			setTotalMoneyAndProductNumber(order);
		}

	}



	
}
