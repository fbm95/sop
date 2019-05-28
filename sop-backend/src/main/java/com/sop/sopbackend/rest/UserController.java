package com.sop.sopbackend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sop.sopbackend.dto.User;
import com.sop.sopbackend.dto.UserAccessToken;
import com.sop.sopbackend.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
	@PostMapping("/login")
	public UserAccessToken forwardLoginUserReq(@RequestBody User user) {
		
		return userService.forwardLoginUserReq(user);
	}

	@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600)
	@PostMapping("/customer/signup")
	public Boolean forwardSignup(@RequestBody User user){
		return userService.forwardSignup(user);
	}

	@GetMapping("/info")
	public User forwardGetInfoUserReq(@RequestHeader("Authorization") String authorization) {
		return userService.forwardGetInfoUserReq(authorization);
	}
	
	
}
