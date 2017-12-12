package org.zzingobomi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/moviegame/")
@Log
public class MovieGameController {
	
	@GetMapping("/list")
	public String list() {
		
		log.info("MovieGame Request!!");
		
		return "/moviegame/list";
	}

}
