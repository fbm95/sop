package com.sop.sopbackend.service;

import com.sop.sopbackend.constant.RestConstant;
import com.sop.sopbackend.dto.User;
import com.sop.sopbackend.dto.UserAccessToken;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

	public static final String USER_URL = RestConstant.DAL + "/user/";
	public static final String IS_AUTH_URL = "isAuthenticated";
	public static final String SIGNUP_CUSTOMER_URL = RestConstant.DAL + "/public/customer/signup";
	public static final String USER_INFO_URL = RestConstant.DAL + "/user/info";

	RestTemplate restTemplate = new RestTemplate();
	
	public Boolean isAuthenticated() {
		return restTemplate.getForObject(USER_URL + IS_AUTH_URL, Boolean.class);
	}
	
	public UserAccessToken forwardLoginUserReq(User user) {

		if(!validateUser(user)){
			return null;
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth("sop", "borsec");
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<?> entity = new HttpEntity<>(headers);

		try {
			ResponseEntity<UserAccessToken> responseEntity = restTemplate.exchange(createLoginUrl(user),
				HttpMethod.POST, entity , UserAccessToken.class);
		
			return responseEntity.getBody();
		}catch(Exception ex){
			System.out.println(ex);
		}

		return null;
	}

	public Boolean forwardSignup(User user){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> entity = new HttpEntity<>(user, headers);

		try {
			ResponseEntity<Boolean> responseEntity = restTemplate.exchange(SIGNUP_CUSTOMER_URL,
					HttpMethod.POST, entity, Boolean.class);

			Boolean result = responseEntity.getBody();
			if (result == false || !responseEntity.getStatusCode().is2xxSuccessful())
				return false;
			return true;
		}catch(Exception ex){
			System.out.println(ex);
		}
		return false;
	}

	public User forwardGetInfoUserReq(String authorization){
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", authorization);
		HttpEntity<?> entity = new HttpEntity<>(headers);

		ResponseEntity<User> responseEntity = restTemplate.exchange(USER_INFO_URL,
				HttpMethod.GET, entity, User.class);

		return responseEntity.getBody();
	}
	
	private String createLoginUrl(User user) {
		StringBuilder loginUrl = new StringBuilder();
		loginUrl
			.append(RestConstant.DAL)
			.append("/oauth/token?")
			.append("password=").append(user.getPassword())
			.append("&username=").append(user.getEmail())
			.append("&grant_type=").append("password")
			.append("&scope=").append("read write");
		return loginUrl.toString();
	}

	private Boolean validateUser(User newUser){
		if(newUser.getPassword() != null && newUser.getEmail() != null &&
				newUser.getPassword().length() > 3 && newUser.getEmail().length() > 3){
			return true;
		}else{
			return false;
		}
	}

	private void handleError(ClientHttpResponse httpResponse){

	}


}
