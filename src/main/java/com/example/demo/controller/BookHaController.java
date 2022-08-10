package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BookHaController {
	
	@GetMapping("/")
	public ModelAndView index(ModelAndView mav) {
		
		mav.setViewName("index");
		
		return mav;
	}
	
	@GetMapping("/user_account_setting")
	public ModelAndView userAccountSetting(ModelAndView mav) {
		mav.setViewName("user_account_setting");
		
		return mav;
	}
}