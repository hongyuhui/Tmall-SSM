package com.pan.tmall.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.pan.tmall.pojo.Category;
import com.pan.tmall.pojo.Product;
import com.pan.tmall.pojo.Productimage;
import com.pan.tmall.service.CategoryService;
import com.pan.tmall.service.ProductImageService;
import com.pan.tmall.service.ProductService;

@Controller
@RequestMapping(value = { "/productImages/" })
public class ProductImageController {

	@Autowired
	private ProductImageService productImageService;
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = { "list" }, method = GET)
	public String list(int id, Model model) {
		Product product = productService.get(id);
		List<Productimage> singleImages = productImageService.list(id, productImageService.TYPE_SINGLE);
		List<Productimage> detailImages = productImageService.list(id, productImageService.TYPE_DETAIL);
		Category category = categoryService.getOne(product.getCid());
		product.setCategory(category);

		model.addAttribute("product", product);
		model.addAttribute("singleImages", singleImages);
		model.addAttribute("detailImages", detailImages);

		return "admin/listProductImages";

	}

	@RequestMapping(value = { "add" }, method = POST)
	public String add(Productimage productimage, @RequestPart("productImage") MultipartFile imageFile,
			HttpServletRequest request) {
		productImageService.add(productimage);
		String path = null;
		String type = productimage.getType();
		String originalName = imageFile.getOriginalFilename();
		String fileType = StringUtils.substringAfterLast(originalName, ".");
		try {
			if (type != null && productImageService.TYPE_DETAIL.equals(type)) {

				path = request.getServletContext().getRealPath("/img/productDetail");
				File file = new File(path + "/" + productimage.getId() + "." + fileType);

				imageFile.transferTo(file);
			}
			if (type != null && productImageService.TYPE_SINGLE.equals(type)) {
				path = request.getServletContext().getRealPath("/img/productSingle");
				System.out.println(path);
				File file = new File(path + "/" + productimage.getId() + "." + fileType);
				imageFile.transferTo(file);
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:list?id=" + productimage.getPid();

	}

	@RequestMapping(value = { "delete" }, method = GET)
	public String delete(int id,int pid) {
		productImageService.delete(id);
		return "redirect:list?id=" + pid;

	}

}
