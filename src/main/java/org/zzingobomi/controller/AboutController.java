package org.zzingobomi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/about/")
@Log
public class AboutController {
	
	@GetMapping("/zzingobomi")
	public String about() {
		
		log.info("About Request!!");
		
		return "/about/about";
	}

}
