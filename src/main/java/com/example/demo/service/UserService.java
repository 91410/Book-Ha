package com.example.demo.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	UserMapper userMapper;
	
	@Transactional
	public void userJoin(User user) {
		user.setUser_mail(user.getUser_mail());
		user.setUser_password(user.getUser_password());
		user.setUser_name(user.getUser_name());
		user.setUser_nickname(user.getUser_nickname());
		user.setUser_phonenumber(user.getUser_phonenumber());
		user.setUser_profile(null);
		user.setUser_profile_size(0);
		user.setUser_self(null);
		user.setUser_enterdate(user.getUser_enterdate());
		user.setUser_final(user.getUser_final());
		user.setUser_role(user.getUser_role());
		user.setUser_option(user.getUser_option());
		
		userMapper.userJoin(user);
	}
	
	@Transactional
	public User signIn(User user) {
		user.setUser_mail(user.getUser_mail());
		user.setUser_password(user.getUser_password());
		
		if(!userMapper.userSignIn(user).isEmpty()) {
			return user;
		}
		
		return null;
	}
	
	@Transactional
	public String chkSameId(User user) {
		if(user.getUser_mail().equals(userMapper.chkSameId(user.getUser_mail()))) {
			return "0";
		}
		
		return "1";
	}
	
	@Transactional
	public String chkSameNickname(User user) {
		if(user.getUser_nickname().equals(userMapper.chkSameNickname(user.getUser_nickname()))) {
			return "0";
		}
		
		return "1";
	}
	
	@Transactional
	public List<Map<String, String>> findUserId(User user) {
		
		return userMapper.findUserId(user);
	}
	
	@Transactional
	public List<Map<String, String>> findPw(User user) {
		
		return userMapper.findPw(user);
	}
}
