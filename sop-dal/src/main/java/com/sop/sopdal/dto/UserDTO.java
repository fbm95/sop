package com.sop.sopdal.dto;

import lombok.Data;

@Data
public class UserDTO {

	private Long id;

	private String email;
	
	private String password;
	
	private String role;
	
	private Boolean isAuthenticated;
	
}
