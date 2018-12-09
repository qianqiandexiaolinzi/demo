package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
	@RequestMapping("index.html")
	public String index() {
		return "/index";		
	}
	
	@RequestMapping("login.html")
	public String login() {
		return "login";
	}
}
