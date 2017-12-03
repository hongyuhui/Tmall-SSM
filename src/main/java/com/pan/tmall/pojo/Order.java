package com.pan.tmall.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pan.tmall.service.OrderService;

@Component
public class Order implements Serializable {
	private Integer id;

	private String ordercode;

	private String address;

	private String post;

	private String receiver;

	private String mobile;

	private String usermessage;

	private Date createdate;

	private Date paydate;

	private Date deliverydate;

	private Date confirmdate;

	private Integer uid;

	private String status;
	private List<Orderitem> orderItems;
	private float total;
	private User user;
	private int totalNumber;

	public String getStatusDesc() {
		String desc = "未知";
		switch (status) {
		case OrderService.waitPay:
			desc = "待付款";
			break;
		case OrderService.waitDelivery:
			desc = "待发货";
			break;
		case OrderService.waitConfirm:
			desc = "待收货";
			break;
		case OrderService.waitReview:
			desc = "等评价";
			break;
		case OrderService.finish:
			desc = "完成";
			break;
		case OrderService.delete:
			desc = "刪除";
			break;
		default:
			desc = "未知";
		}
		return desc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrdercode() {
		return ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUsermessage() {
		return usermessage;
	}

	public void setUsermessage(String usermessage) {
		this.usermessage = usermessage;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getPaydate() {
		return paydate;
	}

	public void setPaydate(Date paydate) {
		this.paydate = paydate;
	}

	public Date getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}

	public Date getConfirmdate() {
		return confirmdate;
	}

	public void setConfirmdate(Date confirmdate) {
		this.confirmdate = confirmdate;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Orderitem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<Orderitem> orderItems) {
		this.orderItems = orderItems;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

}