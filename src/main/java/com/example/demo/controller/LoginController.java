package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;

@RestController
public class LoginController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public ModelAndView login(HttpSession session, ModelAndView mav) {
		mav.setViewName("login");
		
		return mav;
	}
	
	@GetMapping("/signUp")
	public ModelAndView signUp(ModelAndView mav) {
		mav.setViewName("signUp");
		
		return mav;
	}
	
	@PostMapping("/signIn.do")
	public User signIn(HttpServletRequest request, HttpSession session, @RequestBody User user) {
		session = request.getSession();
		session.setAttribute("login", true);
		
		
		return userService.signIn(user);
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("/findUserId")
	public ModelAndView findUserId(ModelAndView mav) {
		mav.setViewName("findUserId");
		
		return mav;
	}
	
	@PostMapping("/findUserId")
	public List<Map<String, String>> findUserId(@RequestBody User user) {
		
		return userService.findUserId(user);
	}
	
	@GetMapping("/findPw")
	public ModelAndView findPw(ModelAndView mav) {
		mav.setViewName("findPw");
		
		return mav;
	}
	
	@PostMapping("/findPw")
	public List<Map<String, String>> findPw(@RequestBody User user) {
		
		return userService.findPw(user);
	}
}
