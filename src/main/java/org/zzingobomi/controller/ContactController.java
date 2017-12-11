package org.zzingobomi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/contact/")
@Log
public class ContactController {
	
	@GetMapping("/zzingobomi")
	public String contact() {
		
		log.info("Contact Request!!");
		
		return "/contact/contact";
	}
}
