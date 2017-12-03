package com.pan.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pan.tmall.mapper.ProductMapper;
import com.pan.tmall.pojo.Category;
import com.pan.tmall.pojo.Product;
import com.pan.tmall.pojo.ProductExample;
import com.pan.tmall.pojo.ProductExample.Criteria;
import com.pan.tmall.pojo.Productimage;
import com.pan.tmall.pojo.Review;
import com.pan.tmall.service.CategoryService;
import com.pan.tmall.service.OrderItemService;
import com.pan.tmall.service.ProductImageService;
import com.pan.tmall.service.ProductService;
import com.pan.tmall.service.ReviewService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private ProductImageService productImageService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private OrderItemService orderItemService;
	@Autowired
	private ReviewService reviewService;

	@Override
	public void setCategory(Product product) {
		Category category = categoryService.getOne(product.getCid());
		product.setCategory(category);
	}

	@Override
	public void setCategory(List<Product> products) {
		for (Product product : products) {
			setCategory(product);
		}

	}

	@Override
	public void setFirstProductImage(Product product) {
		List<Productimage> images = productImageService.list(product.getId(), productImageService.TYPE_SINGLE);
		if (images.isEmpty()) {
			return;
		}
		product.setFirstProductImage(images.get(0));
	}

	@Override
	public void setFirstProductImage(List<Product> products) {
		for (Product product : products) {
			setFirstProductImage(product);
		}

	}

	@Override
	public void add(Product product) {
		productMapper.insert(product);

	}

	@Override
	public void delete(int id) {
		productMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Product product) {
		productMapper.updateByPrimaryKey(product);

	}

	@Override
	public Product get(int id) {
		Product product = productMapper.selectByPrimaryKey(id);
		setFirstProductImage(product);
		return product;
	}

	@Override
	public List<Product> list(int cid) {
		ProductExample example = new ProductExample();
		example.setOrderByClause("id DESC");
		example.createCriteria().andCidEqualTo(cid);
		List<Product> products = productMapper.selectByExample(example);
		setFirstProductImage(products);

		return products;
	}

	@Override
	public void setSaleAndReviewCount(List<Product> products) {
		for (Product product : products) {
			setSaleAndReviewCount(product);
		}
	}

	@Override
	public void setSaleAndReviewCount(Product product) {
		int saleCount = orderItemService.getSaleCount(product.getId());
		product.setSaleCount(saleCount);
		System.out.println(saleCount);

		int reviewCount = reviewService.getCount(product.getId());
		product.setReviewCount(reviewCount);
		System.out.println(reviewCount);

	}

	@Override
	public List<Product> listByKeyWord(String keyWord) {
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameLike("%" + keyWord + "%");
		List<Product> products = productMapper.selectByExample(example);
		return products;
	}

	@Override
	public void setReview(Product product) {
		int reviewCount = reviewService.getCount(product.getId());
		product.setReviewCount(reviewCount);
		List<Review> reviews = reviewService.list(product.getId());
		product.setReviews(reviews);
	}

}
