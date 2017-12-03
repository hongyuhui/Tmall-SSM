package com.pan.tmall.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pan.tmall.pojo.Category;
import com.pan.tmall.pojo.Product;
import com.pan.tmall.pojo.ProductExample;
import com.pan.tmall.service.CategoryService;
import com.pan.tmall.service.ProductService;
import com.pan.tmall.service.PropertyValueService;

@Controller
@RequestMapping(value = { "/product/" })
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PropertyValueService propertyValueService;

	@RequestMapping(value = { "list" }, method = GET)
	public String list(@RequestParam("cid") int categoryId,
			@RequestParam(value = "start", defaultValue = "0") int start, Model model) {
		
		PageHelper.offsetPage(start, 10);
		List<Product> products = productService.list(categoryId);
		Category category = categoryService.getOne(categoryId);
		PageInfo page = new PageInfo<>(products);
		
		model.addAttribute("page", page);
		model.addAttribute("products", products);
		model.addAttribute("category", category);
		model.addAttribute("uri", "product/list");//设置分页跳转路径
		model.addAttribute("condition", "cid="+categoryId);//分页跳转参数
		return "admin/listProducts";
	}

	@RequestMapping(value = { "add" }, method = POST)
	public String add(Product product) {
		productService.add(product);
		propertyValueService.init(product);//初始化属性值
		return "redirect:list?cid=" + product.getCid();
	}

	@RequestMapping(value = { "delete" }, method = GET)
	public String delete(int id, int cid) {
		productService.delete(id);
		return "redirect:list?cid=" + cid;
	}
	
	@RequestMapping(value = { "edit" }, method = GET)
	public String edit( int id,Model model) {
		Product product = productService.get(id);
		Category category = categoryService.getOne(product.getCid());
		product.setCategory(category);
		model.addAttribute("product", product);
		
		return "admin/editProduct";
	}
	
	@RequestMapping(value = { "update" }, method = POST)
	public String uodate( Product product) {
		productService.update(product);
		return "redirect:edit?id="+product.getId();
	}

}
