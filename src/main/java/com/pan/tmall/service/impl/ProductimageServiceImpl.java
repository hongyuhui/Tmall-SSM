package com.pan.tmall.service.impl;

import java.util.List;
import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pan.tmall.mapper.ProductimageMapper;
import com.pan.tmall.pojo.Productimage;
import com.pan.tmall.pojo.ProductimageExample;
import com.pan.tmall.pojo.ProductimageExample.Criteria;
import com.pan.tmall.service.ProductImageService;

@Service
public class ProductimageServiceImpl implements ProductImageService {

	@Autowired
	private ProductimageMapper productimageMapper;

	@Override
	public void add(Productimage productImage) {
		productimageMapper.insert(productImage);

	}

	@Override
	public void delete(int id) {
		productimageMapper.deleteByPrimaryKey(id);

	}

	@Override
	public void update(Productimage pi) {
		// TODO Auto-generated method stub

	}

	@Override
	public Productimage get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Productimage> list(int pid, String type) {
		ProductimageExample example = new ProductimageExample();
		example.setOrderByClause("id DESC");
		Criteria criteria = example.createCriteria();
		criteria.andPidEqualTo(pid);
		criteria.andTypeEqualTo(type);
		List<Productimage> images = productimageMapper.selectByExample(example);
		return images;
	}

}
