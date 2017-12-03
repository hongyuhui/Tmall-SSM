package com.pan.tmall.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pan.tmall.pojo.Category;
import com.pan.tmall.pojo.Product;
import com.pan.tmall.pojo.Propertyvalue;
import com.pan.tmall.service.CategoryService;
import com.pan.tmall.service.ProductService;
import com.pan.tmall.service.PropertyService;
import com.pan.tmall.service.PropertyValueService;

@Controller
@RequestMapping("/propertyValue/")
public class PropertyValueController {

	@Autowired
	private PropertyValueService propertyValueService;
	@Autowired
	private PropertyService propertyService;
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value= {"list"},method=GET)
	public String list(int pid,Model model) {
		
		List<Propertyvalue> values=	propertyValueService.list(pid);
		propertyValueService.setProperty(values);
		Product product = productService.get(pid);
		Category  category = categoryService.getOne(product.getCid());
		product.setCategory(category);
		
		model.addAttribute("propertyValues", values);
		model.addAttribute("product", product);
		
		return "admin/editPropertyValues";
	}
	@RequestMapping(value= {"update"},method=POST)
	@ResponseBody
	public String update(Propertyvalue propertyvalue) {
		propertyValueService.update(propertyvalue);
		return "success";
	}
}
