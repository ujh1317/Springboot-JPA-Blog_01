package com.example.blog_01.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog_01.dto.ResponseDto;
import com.example.blog_01.model.RoleType;
import com.example.blog_01.model.User;
import com.example.blog_01.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) { //username, password, email
		System.out.println("UserApiController : save 호출됨");
		
		user.setRole(RoleType.USER);
		int result = userService.save(user);
		
		return new ResponseDto<Integer>(HttpStatus.OK, 1);
	}//save()
	
}//class
