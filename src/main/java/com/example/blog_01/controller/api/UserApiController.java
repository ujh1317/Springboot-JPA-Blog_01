package com.example.blog_01.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog_01.config.auth.PrincipalDetail;
import com.example.blog_01.dto.ResponseDto;
import com.example.blog_01.model.RoleType;
import com.example.blog_01.model.User;
import com.example.blog_01.service.UserService;

@RestController
public class UserApiController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) { //username, password, email
		System.out.println("UserApiController : save 호출됨");
		
		userService.join(user);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}//save()
	
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user) {
		userService.userUpdate(user);
		//세션 등록
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
				
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}//update()
	
	
	/*
	 시큐리티로 대체
	@PostMapping("/api/user/login")
	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) {
		System.out.println("UserApiController : login 호출됨");
		
		User principal = userService.login(user); //principal(접근주체)
		if(principal != null) {
			session.setAttribute("principal", principal);
		}//if
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}//login()
	*/
	
}//class
