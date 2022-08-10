package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.User;

@Mapper
public interface UserMapper {
	void userJoin(User user);
	
	void kakaoUserJoin(User user);
	
	List<Map<String, String>> userSignIn(User user);
	
	String chkSameId(String string);
	
	String chkSameNickname(String string);
	
	List<Map<String, String>> findUserId(User user);
	
	List<Map<String, String>> findPw(User user);
	
	void deleteAccount(User user);
	
	void updateAccount(User user);
}
