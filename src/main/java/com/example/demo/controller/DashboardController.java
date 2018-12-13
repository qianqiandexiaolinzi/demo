package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.bean.ResultJson;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DashboardController {
	@Autowired
	private UserService userService;

	@RequestMapping("index.html")
	public String index() {
		return "/index";		
	}
	
	@RequestMapping("login.html")
	public String login() {
		return "login";
	}

	@RequestMapping("doLogin.json")
	@ResponseBody
	public ResultJson Login(String userName, String password, HttpServletRequest httpServletRequest, HttpServletResponse response){
		User user2 = userService.findByUserName(userName);
		if(user2 == null){
			return new ResultJson(ResultJson.ERROR,  "此用户不存在");
		}
		if(!password.equals(user2.getPassword())){
			return new ResultJson(ResultJson.ERROR,"密码输入不正确");
		}
		httpServletRequest.getSession().setAttribute("user",user2);
		return new ResultJson(ResultJson.SUCCESS,"验证通过");
	}
}
