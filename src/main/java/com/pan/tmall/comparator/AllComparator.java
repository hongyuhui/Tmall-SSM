package com.pan.tmall.comparator;

import java.util.Comparator;

import com.pan.tmall.pojo.Product;

public class AllComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		// TODO Auto-generated method stub
		return o1.getReviewCount()*o1.getSaleCount()-o2.getReviewCount()*o2.getSaleCount();
	}

}
