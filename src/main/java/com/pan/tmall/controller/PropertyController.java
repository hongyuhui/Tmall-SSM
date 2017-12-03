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
import com.pan.tmall.pojo.Property;
import com.pan.tmall.service.CategoryService;
import com.pan.tmall.service.PropertyService;

@Controller
@RequestMapping(value = { "/property/" })
public class PropertyController {

	@Autowired
	private PropertyService propertyService;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = { "list" }, method = GET)
	public String list(Model model, @RequestParam(value = "start", defaultValue = "0") int start,
			@RequestParam(value = "cid", defaultValue = "0") int categoryId) {

		PageHelper.offsetPage(start, 10);
		List<Property> properties = propertyService.list(categoryId);
		PageInfo page = new PageInfo<>(properties);// 获取查询结果的信息
		Category category = categoryService.getOne(categoryId);

		model.addAttribute("properties", properties);
		model.addAttribute("category", category);
		model.addAttribute("page", page);
		model.addAttribute("uri", "property/list");
		model.addAttribute("condition", "cid=" + categoryId);

		return "admin/listProperties";
	}

	@RequestMapping(value = { "add" }, method = GET)
	public String add(Property property) {
		propertyService.add(property);
		return "redirect:list?cid=" + property.getCid();
	}

	@RequestMapping(value = { "delete" }, method = GET)
	public String delete(Property property) {
		propertyService.delete(property);
		return "redirect:list?cid=" + property.getCid();
	}

	@RequestMapping(value = { "edit" }, method = GET)
	public String edit(@RequestParam("id") int propertyId, Model model) {
		Property property = propertyService.getOne(propertyId);
		Category category = categoryService.getOne(property.getCid());
		property.setCategory(category);
		model.addAttribute("property", property);
		return "admin/editProperty";
	}

	@RequestMapping(value = { "update" }, method = POST)
	public String update(Property property) {
		propertyService.update(property);
		
		return "redirect:list?cid=" + property.getCid();
	}
}
