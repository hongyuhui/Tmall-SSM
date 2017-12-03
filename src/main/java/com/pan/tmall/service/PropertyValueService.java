package com.pan.tmall.service;

import java.util.List;

import com.pan.tmall.pojo.Product;
import com.pan.tmall.pojo.Propertyvalue;

public interface PropertyValueService {
	void init(Product product);

	void update(Propertyvalue propertyvalue);

	Propertyvalue get(int productId,int propertyId);
	
	List<Propertyvalue> list(int pid);
	
	void setProperty(Propertyvalue value);
	
	void setProperty(List<Propertyvalue> values);

}
