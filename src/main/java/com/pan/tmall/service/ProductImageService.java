package com.pan.tmall.service;

import java.util.List;

import com.pan.tmall.pojo.Productimage;

public interface ProductImageService {

	final String TYPE_SINGLE = "type_single";
	final String TYPE_DETAIL = "type_detail";

	void add(Productimage productImage);

	void delete(int id);

	void update(Productimage productimage);

	Productimage get(int id);

	List<Productimage> list(int pid, String type);
}
