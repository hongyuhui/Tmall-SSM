package com.pan.tmall.comparator;

import java.util.Comparator;

import com.pan.tmall.pojo.Product;

public class CreateDateComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {

		return o2.getCreatedate().compareTo(o1.getCreatedate());
	}

}
