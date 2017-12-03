package com.pan.tmall.service;

import java.util.List;

import com.pan.tmall.pojo.User;

public interface UserService {
	User get(int id);

	void add(User user);

	void delete(User user);

	void update(User user);

	List<User> list();

	User get(User user);

}
