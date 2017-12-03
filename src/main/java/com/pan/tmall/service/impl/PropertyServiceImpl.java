package com.pan.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pan.tmall.mapper.PropertyMapper;
import com.pan.tmall.pojo.Property;
import com.pan.tmall.pojo.PropertyExample;
import com.pan.tmall.pojo.PropertyExample.Criteria;
import com.pan.tmall.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {
	@Autowired
	private PropertyMapper propertyMapper;

	@Override
	public List<Property> list(int categoryId) {
		PropertyExample example = new PropertyExample();
		example.setOrderByClause("id DESC");
		Criteria criteria = example.createCriteria();
		criteria.andCidEqualTo(categoryId);
		return propertyMapper.selectByExample(example);
	}

	@Override
	public void add(Property property) {
		propertyMapper.insertSelective(property);
	}

	@Override
	public void delete(Property property) {
		propertyMapper.deleteByPrimaryKey(property.getId());
	}

	@Override
	public Property getOne(int propertyId) {
		
		return propertyMapper.selectByPrimaryKey(propertyId);
	}

	@Override
	public void update(Property property) {
		propertyMapper.updateByPrimaryKey(property);
		
	}
	
	
	

}
