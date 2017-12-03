package com.pan.tmall.service;

import java.util.List;

import com.pan.tmall.pojo.Review;

public interface ReviewService {

	void add(Review c);

	void delete(int id);

	void update(Review c);

	Review get(int id);
	void setUser(Review review);
	void setUser(List<Review> reviews);

	List<Review> list(int pid);

	int getCount(int pid);
}
