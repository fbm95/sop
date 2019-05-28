package com.sop.sopdal.service;

import com.sop.sopdal.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import com.sop.sopdal.dto.UserDTO;
import com.sop.sopdal.repository.UserRepository;
import com.sop.sopdal.transformer.UserTransformer;

@Service("userDetailsService")
public class UserService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserTransformer userTransformer;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserDetails user = userRepository.findOneByEmail(email);
		if(user == null){
			throw new UsernameNotFoundException("Bad credentials!");
		}
		return user;
	}
	
	public UserDTO getUserDetails(OAuth2Authentication oauth2) {
		return userTransformer.Oauth2ToDTO(oauth2);
	}

	public Boolean signupWithRole(UserDTO newUser, String role){
		newUser.setRole(role);
		if(checkUserExists(newUser) && validateUser(newUser)) {
			PasswordEncoder passwordEncoder = new StandardPasswordEncoder();
			newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
			User user = userRepository.save(userTransformer.toEntity(newUser));
			return user.getId() != null ? true : false;
		}else{
			return false;
		}
	}

	private Boolean validateUser(UserDTO newUser){
		if(newUser.getPassword() != null && newUser.getEmail() != null &&
			newUser.getPassword().length() > 3 && newUser.getEmail().length() > 3){
			return true;
		}else{
			return false;
		}
	}

	private Boolean checkUserExists(UserDTO newUser){
		User user = userRepository.findOneByEmail(newUser.getEmail());
		if(user != null)
			return false;
		return true;
	}

}
