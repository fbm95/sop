package com.sop.sopbackend.rest;

import com.sop.sopbackend.config.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alive")
public class AliveController {

	@Autowired
	EmailService emailService;

	@GetMapping
	public Boolean alive() {
		try {
			emailService.sendEmail("nicauandrei@gmail.com", "Hi", "Works!");
		}catch(Exception ex){
			System.out.println(ex);
		}
		return true;
	}
	
	
}
