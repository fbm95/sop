package com.sop.sopdal.transformer;

import com.sop.sopdal.domain.SystemUserDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;

import com.sop.sopdal.domain.User;
import com.sop.sopdal.dto.UserDTO;

@Component
public class UserTransformer implements Transformer<User,UserDTO> {

	@Override
	public User toEntity(UserDTO dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setEmail(dto.getEmail());
		user.setSystemUserDetails(new SystemUserDetails());
		user.getSystemUserDetails().setPassword(dto.getPassword());
		user.getSystemUserDetails().setRole(dto.getRole());
		return user;
	}

	@Override
	public UserDTO toDTO(User entity) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(entity.getId());
		userDTO.setEmail(entity.getEmail());
		userDTO.setPassword(entity.getSystemUserDetails().getPassword());
		userDTO.setRole(entity.getSystemUserDetails().getRole());
		return userDTO;
	}

	public UserDTO Oauth2ToDTO(OAuth2Authentication oauth2) {
		UserDTO userDTO = new UserDTO();
		User entity = (User)oauth2.getUserAuthentication().getPrincipal();
		userDTO.setId(entity.getId());
		userDTO.setIsAuthenticated(oauth2.isAuthenticated());
		userDTO.setRole(entity.getSystemUserDetails().getRole());
		userDTO.setEmail(entity.getEmail());
		return userDTO;
	}
	
}
