package com.pan.tmall.service;

import java.util.List;

import com.pan.tmall.pojo.Order;
import com.pan.tmall.pojo.Orderitem;
import com.pan.tmall.pojo.User;

public interface OrderItemService {
	void add(Orderitem c);

	void delete(int id);

	void update(Orderitem c);

	Orderitem get(int id);

	Orderitem getByProductId(int productId);

	List<Orderitem> list();

	List<Orderitem> listByUser(User user);

	List<Orderitem> listByOrder(Order order);

	void fill(List<Order> os);

	void fill(Order o);

	void setProduct(Orderitem orderitem);

	void setProduct(List<Orderitem> orderitems);

	int getSaleCount(int pid);

	void setReview(Orderitem orderitem);

	void setRview(List<Orderitem> orderitems);

}
