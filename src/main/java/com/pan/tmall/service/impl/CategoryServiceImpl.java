package com.pan.tmall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pan.tmall.mapper.CategoryMapper;
import com.pan.tmall.pojo.Category;
import com.pan.tmall.pojo.CategoryExample;
import com.pan.tmall.pojo.Product;
import com.pan.tmall.service.CategoryService;
import com.pan.tmall.service.ProductService;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private ProductService productService;

	public List<Category> list() {
		CategoryExample example = new CategoryExample();
		example.setOrderByClause("id DESC");
		return categoryMapper.selectByExample(example);
	}

	public void add(Category category) {
		categoryMapper.insertSelective(category);
	}

	public void delete(int categoryId) {
		categoryMapper.deleteByPrimaryKey(categoryId);
	}

	public Category getOne(int categoryId) {
		return categoryMapper.selectByPrimaryKey(categoryId);

	}

	public void update(Category category) {
		categoryMapper.updateByPrimaryKeySelective(category);
	}

	@Override
	public void fillProductsByRow(Category category) {
		List<Product> products = productService.list(category.getId());
		int numberOfEachRow = 8;
		List<List<Product>> productsByRow = new ArrayList<List<Product>>();
		;
		for (int i = 0; i < products.size(); i += numberOfEachRow) {
			int end = i + numberOfEachRow;
			if (end > products.size()) {
				end = products.size();
			}
			productsByRow.add(products.subList(i, end));
		}
		category.setProductsByRow(productsByRow);

	}

	@Override
	public void fillProductsByRow(List<Category> categories) {
		for (Category category : categories) {
			fillProductsByRow(category);
		}
	}

	@Override
	public void fillProducts(Category category) {
		List<Product> products = productService.list(category.getId());
		category.setProducts(products);
		
	}

	@Override
	public void fillProducts(List<Category> categories) {
		for (Category category : categories) {
			fillProducts(category);
		}
		
	}

	
}
