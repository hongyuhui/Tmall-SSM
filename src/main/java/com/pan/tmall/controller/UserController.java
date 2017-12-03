package com.pan.tmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pan.tmall.pojo.User;
import com.pan.tmall.service.UserService;

@Controller
@RequestMapping(value= {"/user/"})
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value= {"list"},method=RequestMethod.GET)
	public String list(@RequestParam(value="start",defaultValue="0") int start,Model model) {
		PageHelper.offsetPage(start, 10);
		List<User> users = userService.list();
		PageInfo  page = new PageInfo<>(users);
		
		
		model.addAttribute("users", users);
		model.addAttribute("page", page);
		model.addAttribute("uri", "user/list");
		return "admin/listUser";
	}
}
