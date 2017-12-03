package com.pan.tmall.comparator;

import java.util.Comparator;

import com.pan.tmall.pojo.Product;

public class ReviewComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {

		int r1 = o1.getReviewCount();
		int r2 = o2.getReviewCount();
		return r2-r1;
	}

}
