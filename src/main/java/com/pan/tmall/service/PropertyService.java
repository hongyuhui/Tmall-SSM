package com.pan.tmall.service;

import java.util.List;

import com.pan.tmall.pojo.Property;

public interface PropertyService {
	public List<Property> list(int categoryId);
	public void add(Property property);
	public void delete(Property property);
	public Property getOne(int propertyId);
	public void update(Property property);
	
	
}
