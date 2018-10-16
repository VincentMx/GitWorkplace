package com.jd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jd.model.User;
import com.jd.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	private int count;
	@Autowired
	private UserService userService;
    /**
     * 查询某个用户
     * */
	@RequestMapping(value = "/findUserById")
	public ModelAndView findUserById(@RequestParam("id") int id, ModelMap map) {
		map.addAttribute("user", userService.findUserById(id));
		return new ModelAndView("index",map);
	}
	/**
     * 查询所有用户
     * */
	@RequestMapping(value = "/findAllUser")
	
	public ModelAndView findAllUser(ModelMap map,HttpServletRequest request){
		int pageNow=1;
		if("".equals(request.getParameter("pageNow"))||request.getParameter("pageNow")==null){
			pageNow=1;
		}else{
			pageNow=Integer.parseInt(request.getParameter("pageNow"));
		}
		int everyPage=3;
		map.addAttribute("users", userService.findAllUser(pageNow,everyPage)[1]);
		map.addAttribute("totalPage", userService.findAllUser(pageNow,everyPage)[0]);
		map.addAttribute("pageNow", pageNow);
		return new ModelAndView("index",map);
	}
	/**
     * 删除用户
     * */
	@RequestMapping(value="/delUser")
	public String delUser(@RequestParam("id") int id){
		count=userService.deleteUser(id);
		if(count!=0){
			return "redirect:findAllUser";
		}else{
			return "error";
		}
		
	}
	/**
     * 插入用户
     * */
	@RequestMapping(value="/insertUser",method=RequestMethod.POST)
	public String insertUser(User user){
		count=userService.insertUser(user);
		if(count!=0){
			return "redirect:findAllUser";
		}else{
			return "error";
		}
	}
	
	
}
