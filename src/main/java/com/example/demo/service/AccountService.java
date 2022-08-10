package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;

@Service
public class AccountService {
	
	@Autowired
	UserMapper userMapper;
	
	@Transactional
	public void deleteAccount(User user) {
		user.setUser_mail(user.getUser_mail());
		user.setUser_password(user.getUser_password());
		
		userMapper.deleteAccount(user);
	}
	
	@Transactional
	public void updateAccount(User user) {
		user.setUser_mail(user.getUser_mail());
		user.setUser_password(user.getUser_password());
		user.setUser_nickname(user.getUser_nickname());
		user.setUser_phonenumber(user.getUser_phonenumber());
		user.setUser_self(user.getUser_self());
		
		userMapper.updateAccount(user);
	}

}
