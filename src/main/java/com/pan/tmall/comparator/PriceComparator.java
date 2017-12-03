package com.pan.tmall.comparator;

import java.util.Comparator;

import com.pan.tmall.pojo.Product;

public class PriceComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		// TODO Auto-generated method stub
		return (int) (o1.getPromoteprice()-o2.getPromoteprice());
	}

}
