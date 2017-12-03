package com.pan.tmall.pojo;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Propertyvalue implements Serializable {
	private Integer id;

	private String productid;

	private Integer propertyid;

	private String value;
	private Property property;

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid == null ? null : productid.trim();
	}

	public Integer getPropertyid() {
		return propertyid;
	}

	public void setPropertyid(Integer propertyid) {
		this.propertyid = propertyid;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value == null ? null : value.trim();
	}
}