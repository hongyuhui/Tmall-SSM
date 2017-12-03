package com.pan.tmall.service;

import java.util.List;

import com.pan.tmall.pojo.Order;
import com.pan.tmall.pojo.Orderitem;
import com.pan.tmall.pojo.User;

public interface OrderService {
	String waitPay = "waitPay";
	String waitDelivery = "waitDelivery";
	String waitConfirm = "waitConfirm";
	String waitReview = "waitReview";
	String finish = "finish";
	String delete = "delete";

	Order get(int oid);

	void delete(Order order);

	void edit(int orderId);

	void update(Order order);

	List<Order> list();

	List<Order> listByUser(User user);

	void setUser(Order order);

	void setUser(List<Order> orders);

	void delivery(Order order);

	float add(Order order, List<Orderitem> orderitems);

	void setOrderItem(Order order);

	void setOrderItem(List<Order> orders);

	void setTotalMoneyAndProductNumber(Order order);

	void setTotalMoneyAndProductNumber(List<Order> orders);


}
