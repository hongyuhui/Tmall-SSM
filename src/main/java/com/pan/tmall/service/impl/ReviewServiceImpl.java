package com.pan.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pan.tmall.mapper.ReviewMapper;
import com.pan.tmall.pojo.Review;
import com.pan.tmall.pojo.ReviewExample;
import com.pan.tmall.pojo.User;
import com.pan.tmall.service.ReviewService;
import com.pan.tmall.service.UserService;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewMapper reviewMapper;
	@Autowired
	private UserService userService;

	@Override
	public void add(Review c) {
		reviewMapper.insertSelective(c);
		

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Review c) {
		// TODO Auto-generated method stub

	}

	@Override
	public Review get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> list(int pid) {
		ReviewExample example = new ReviewExample();
		example.setOrderByClause("id DESC");
		example.createCriteria().andPidEqualTo(pid);
		List<Review> reviews = reviewMapper.selectByExample(example);
		return reviews;
	}

	@Override
	public int getCount(int pid) {
		ReviewExample example = new ReviewExample();
		example.createCriteria().andPidEqualTo(pid);

		return (int) reviewMapper.countByExample(example);
	}

	@Override
	public void setUser(Review review) {
		User user = userService.get(review.getUid());
		review.setUser(user);
		
	}

	@Override
	public void setUser(List<Review> reviews) {
		for (Review review : reviews) {
			setUser(review);
		}
		
	}
	
	

}
