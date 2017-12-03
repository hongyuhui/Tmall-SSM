package com.pan.tmall.service;

import java.util.List;

import com.pan.tmall.pojo.Product;

public interface ProductService {
	void add(Product product);

	void delete(int id);

	void update(Product product);

	Product get(int id);

	void setSaleAndReviewCount(Product product);

	void setSaleAndReviewCount(List<Product> products);

	List<Product> list(int cid);

	void setCategory(Product product);

	void setCategory(List<Product> products);

	void setFirstProductImage(Product product);

	void setFirstProductImage(List<Product> products);
	
	List<Product> listByKeyWord(String keyWord);
	
	void setReview(Product product);

}
