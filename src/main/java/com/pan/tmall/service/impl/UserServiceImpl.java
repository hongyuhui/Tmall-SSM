package com.pan.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pan.tmall.mapper.UserMapper;
import com.pan.tmall.pojo.User;
import com.pan.tmall.pojo.UserExample;
import com.pan.tmall.pojo.UserExample.Criteria;
import com.pan.tmall.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void add(User user) {
		userMapper.insert(user);

	}

	@Override
	public void delete(User user) {
		userMapper.deleteByPrimaryKey(user.getId());

	}

	@Override
	public void update(User user) {
		userMapper.updateByPrimaryKeySelective(user);

	}

	@Override
	public List<User> list() {
		UserExample example = new UserExample();
		example.setOrderByClause("id desc");
		return userMapper.selectByExample(example);
	}

	@Override
	public User get(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public User get(User user) {
		UserExample example = new UserExample();
		Criteria criteria = 	example.createCriteria();
		criteria.andNameEqualTo(user.getName());
		criteria.andPasswordEqualTo(user.getPassword());
		List<User> users = userMapper.selectByExample(example);
		if (users.size()>0) {
			return users.get(0);
		}
		return null;
	}

}
