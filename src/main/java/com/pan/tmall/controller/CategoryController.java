package com.pan.tmall.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pan.tmall.pojo.Category;
import com.pan.tmall.service.CategoryService;

@Controller
@RequestMapping(value = { "/category" })
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private HttpServletRequest request;

	@RequestMapping(value = { "/list" }, method = GET)
	public String listCategory(Model model, @RequestParam(value = "start", defaultValue = "0") int start) {
		
		PageHelper.offsetPage(start, 10);
		List<Category> cs = categoryService.list();
		PageInfo page = new PageInfo<>(cs);
		
		model.addAttribute("categories", cs);
		model.addAttribute("page", page);
		model.addAttribute("uri", "category/list");
		return "admin/listCategory";
	}

	@RequestMapping(value = { "/add" }, method=POST)
	public String addCategory(Category category, @RequestPart("categoryImg") MultipartFile categoryImg) {
		categoryService.add(category);
		try {
			String path = request.getSession().getServletContext().getRealPath("/img");
			// 获取文件类型
			String fileOriginalName = categoryImg.getOriginalFilename();
			String fileType = StringUtils.substringAfterLast(fileOriginalName, ".");
			categoryImg.transferTo(new File(path + "/category/" + category.getId() + "." + fileType));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 重定向，forward:为请求转发
		return "redirect:list";
	}

	@RequestMapping(value = { "/delete" }, method = GET)
	public String deleteCategory(@RequestParam("cid") int categoryId) {
		categoryService.delete(categoryId);
		return "redirect:list";
	}

	@RequestMapping(value = { "/edit" }, method = GET)
	public String editCategory(Model model, @RequestParam("cid") int categoryId) {
		Category category = categoryService.getOne(categoryId);
		model.addAttribute("category", category);
		return "admin/editCategory";
	}

	@RequestMapping(value = { "/update" }, method = POST)
	public String updateCategory(Category category, @RequestPart("categoryImage") MultipartFile image) {
		categoryService.update(category);
		if(image.getSize()!=0) {
			String path = request.getSession().getServletContext().getRealPath("/category");
			File file = new File(path+"/"+category.getId()+".jpg");
			if (file.exists()) {
				file.delete();
			}
			try {
				image.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:list";
	}
}
