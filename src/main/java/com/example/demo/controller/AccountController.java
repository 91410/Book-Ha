package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.service.AccountService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(value="account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/update")
	public User updateAccount(@RequestBody User user) {
		accountService.updateAccount(user);
		return user;
	}
	
	
	@PostMapping("/delete")
	public User deleteAccount(@RequestBody User user) {
		accountService.deleteAccount(user);
		
		return user;
		
	}
}
