package com.example.blog_01.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog_01.model.User;
import com.example.blog_01.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void join(User user) {
		userRepository.save(user);
	}//save()
	
	/*
	@Transactional(readOnly = true) //정합성 유지
	public User login(User user) {
		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}//login()
	*/
	
}//class
