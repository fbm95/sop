package com.sop.sopbackend.dto;

import lombok.Data;

@Data
public class UserAccessToken {

	private String access_token;
	private String token_type;
	private String refresh_token;
	private String expires_in;
	private String scope;
	
}
