package com.pan.tmall.service;

import java.util.List;

import com.pan.tmall.pojo.Category;

public interface CategoryService {
	public List<Category> list();
	public void fillProducts(Category category);
	public void fillProducts(List<Category> categories);
	public void add(Category category);
	public void delete(int categoryId);
	public Category getOne(int categoryId);
	public void update(Category category);
	public void fillProductsByRow(Category category);
	public void fillProductsByRow(List<Category> categories);
}
