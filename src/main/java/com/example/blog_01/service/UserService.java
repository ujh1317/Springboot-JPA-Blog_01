package com.example.blog_01.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog_01.model.User;
import com.example.blog_01.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public int save(User user) {
		try {
			userRepository.save(user);
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("UserService : save() : "+e.getMessage());
		}//catch
		return -1;
	}//save()
	
}//class
