package com.pan.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pan.tmall.mapper.OrderitemMapper;
import com.pan.tmall.pojo.Order;
import com.pan.tmall.pojo.Orderitem;
import com.pan.tmall.pojo.OrderitemExample;
import com.pan.tmall.pojo.OrderitemExample.Criteria;
import com.pan.tmall.pojo.Product;
import com.pan.tmall.pojo.User;
import com.pan.tmall.service.OrderItemService;
import com.pan.tmall.service.ProductService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	@Autowired
	private OrderitemMapper orderitemMapper;
	@Autowired
	private ProductService productService;

	@Override
	public void add(Orderitem orderitem) {
		orderitemMapper.insertSelective(orderitem);

	}

	@Override
	public void delete(int id) {
		orderitemMapper.deleteByPrimaryKey(id);

	}

	@Override
	public void update(Orderitem orderitem) {
		orderitemMapper.updateByPrimaryKeySelective(orderitem);
	}

	@Override
	public Orderitem get(int id) {
		Orderitem orderitem = orderitemMapper.selectByPrimaryKey(id);
		setProduct(orderitem);
		return orderitem;
	}

	@Override
	public List list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fill(List<Order> os) {
		// TODO Auto-generated method stub
		for (Order order : os) {
			fill(order);
		}

	}

	@Override
	public void fill(Order o) {
		// TODO Auto-generated method stub
		OrderitemExample example = new OrderitemExample();
		example.createCriteria().andOidEqualTo(o.getId());
		List<Orderitem> orderitems = orderitemMapper.selectByExample(example);
		setProduct(orderitems);
		float total = 0;
		int totalNumber = 0;
		for (Orderitem orderitem : orderitems) {
			total += orderitem.getNumber() * orderitem.getProduct().getPromoteprice();
			totalNumber += orderitem.getNumber();
		}
		o.setTotal(total);
		o.setTotalNumber(totalNumber);
		o.setOrderItems(orderitems);
	}

	@Override
	public void setProduct(Orderitem orderitem) {
		Product product = productService.get(orderitem.getPid());
		orderitem.setProduct(product);

	}

	// 装配Product
	@Override
	public void setProduct(List<Orderitem> orderitems) {
		for (Orderitem orderitem : orderitems) {
			setProduct(orderitem);
		}
	}

	// 获取销量
	@Override
	public int getSaleCount(int pid) {
		OrderitemExample example = new OrderitemExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(pid);
		criteria.andOidNotEqualTo(-1);

		List<Orderitem> ois = orderitemMapper.selectByExample(example);
		int saleCount = 0;
		for (Orderitem orderitem : ois) {
			saleCount += orderitem.getNumber();
		}
		return saleCount;
	}

	@Override
	public List<Orderitem> listByUser(User user) {
		OrderitemExample example = new OrderitemExample();
		Criteria criteria = example.createCriteria();
		criteria.andUidEqualTo(user.getId());
		criteria.andOidEqualTo(-1);
		List<Orderitem> ois = orderitemMapper.selectByExample(example);
		setProduct(ois);
		return ois;
	}

	@Override
	public List<Orderitem> listByOrder(Order order) {
		OrderitemExample example = new OrderitemExample();
		Criteria criteria = example.createCriteria();
		criteria.andOidEqualTo(order.getId());
		List<Orderitem> ois = orderitemMapper.selectByExample(example);
		setProduct(ois);
		return ois;
	}

	@Override
	public Orderitem getByProductId(int productId) {
		OrderitemExample example = new OrderitemExample();
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(productId);
		List<Orderitem> ois = orderitemMapper.selectByExample(example);
		if (ois != null && !ois.isEmpty()) {
			setProduct(ois);
			return ois.get(0);
		}
		return null;
	}

	@Override
	public void setReview(Orderitem orderitem) {

		productService.setReview(orderitem.getProduct());

	}

	@Override
	public void setRview(List<Orderitem> orderitems) {
		for (Orderitem orderitem : orderitems) {
			setReview(orderitem);
		}

	}

}
