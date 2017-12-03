package com.pan.tmall.comparator;

import java.util.Comparator;

import com.pan.tmall.pojo.Product;

public class SaleCountComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		
		return o2.getSaleCount()-o1.getSaleCount();
	}

}
