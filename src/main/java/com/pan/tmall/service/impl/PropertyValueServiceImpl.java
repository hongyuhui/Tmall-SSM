package com.pan.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pan.tmall.mapper.PropertyMapper;
import com.pan.tmall.mapper.PropertyvalueMapper;
import com.pan.tmall.pojo.Product;
import com.pan.tmall.pojo.Property;
import com.pan.tmall.pojo.Propertyvalue;
import com.pan.tmall.pojo.PropertyvalueExample;
import com.pan.tmall.service.PropertyService;
import com.pan.tmall.service.PropertyValueService;

@Service
public class PropertyValueServiceImpl implements PropertyValueService {
	@Autowired
	private PropertyvalueMapper propertyvalueMapper;
	@Autowired
	private PropertyMapper propertyMapper;

	@Autowired
	private PropertyService propertyService;

	// 商品刚创建时是没有属性值存在数据库中的，所以创建后要初始化一下
	@Override
	public void init(Product product) {
		int pid = product.getId();
		List<Property> properties = propertyService.list(product.getCid());
		for (Property property : properties) {
			Propertyvalue propertyvalue = get(pid, property.getId());
			if (propertyvalue == null) {
				propertyvalue = new Propertyvalue();
				propertyvalue.setProductid("" + pid);
				propertyvalue.setPropertyid(property.getId());
				propertyvalueMapper.insert(propertyvalue);
			}
		}
	}

	@Override
	public void update(Propertyvalue propertyvalue) {
		propertyvalueMapper.updateByPrimaryKeySelective(propertyvalue);

	}

	@Override
	public Propertyvalue get(int productId, int propertyId) {
		Propertyvalue value = null;
		PropertyvalueExample example = new PropertyvalueExample();
		example.createCriteria().andProductidEqualTo("" + productId);
		example.createCriteria().andPropertyidEqualTo(propertyId);
		List<Propertyvalue> propertyvalues = propertyvalueMapper.selectByExample(example);
		if (!propertyvalues.isEmpty()) {
			value = propertyvalues.get(0);
		}
		return value;
	}

	@Override
	public List<Propertyvalue> list(int pid) {
		PropertyvalueExample example = new PropertyvalueExample();
		example.createCriteria().andProductidEqualTo("" + pid);

		return propertyvalueMapper.selectByExample(example);
	}

	// 填充Property
	@Override
	public void setProperty(Propertyvalue value) {
		Property property = propertyMapper.selectByPrimaryKey(value.getPropertyid());
		value.setProperty(property);
	}

	@Override
	public void setProperty(List<Propertyvalue> values) {
		for (Propertyvalue propertyvalue : values) {
			setProperty(propertyvalue);
		}
	}

}
