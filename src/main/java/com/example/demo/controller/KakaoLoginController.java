package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.User;
import com.example.demo.service.KakaoUserService;
import com.example.demo.service.UserService;



@RestController
@RequestMapping(value="/kakaoUser")
public class KakaoLoginController {

	@Autowired
	private KakaoUserService userService;
	
	@GetMapping("/kakao_add")
	public ModelAndView kakaoAdd(ModelAndView mav) {
		mav.setViewName("kakao_add");
		
		return mav;
	}
	
	@PostMapping("/userInfo")
	public User userInfo(@RequestBody User user) {
		userService.kakaoUserJoin(user);
		
		return user;
	}
}
