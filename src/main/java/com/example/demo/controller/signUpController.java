package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(value="signUp")
public class signUpController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/register_policy")
	public ModelAndView policy(ModelAndView mav) {
		mav.setViewName("register_policy");
		
		return mav;
	}
	
	@PostMapping("/new")
	public User singUpForNew(@RequestBody User user) {
		userService.userJoin(user);
		
		return user;
	}
	
	@PostMapping("/chkSameId")
	public String chkSameId(@RequestBody User user) {
		return userService.chkSameId(user);
	}
	
	@PostMapping("/chkSameNickname")
	public String chkSameNickname(@RequestBody User user) {
		return userService.chkSameNickname(user);
	}
	
}
