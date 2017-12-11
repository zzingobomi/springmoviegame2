package org.zzingobomi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Controller
@Log
public class HomeController {

	@GetMapping("/")
	public String home() {
		
		log.info("HomeController!");
		
		return "home/home";
	}
}
