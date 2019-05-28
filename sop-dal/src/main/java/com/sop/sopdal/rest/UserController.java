package com.sop.sopdal.rest;

import com.sop.sopdal.dto.UserDTO;
import com.sop.sopdal.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	UserService userService;
    
    @RequestMapping(value = "/user/info", method = RequestMethod.GET)
    public UserDTO getUserInfo(OAuth2Authentication oauth2) {
    	return userService.getUserDetails(oauth2);
    }

    @RequestMapping(value = "/public/customer/signup", method = RequestMethod.POST)
    public Boolean signup(@RequestBody UserDTO user){
        return userService.signupWithRole(user, "CUSTOMER");
    }

}
