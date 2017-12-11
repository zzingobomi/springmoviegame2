package org.zzingobomi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/blog/")
@Log
public class BlogController {

	@GetMapping("/list")
	public String list() {
		
		log.info("Blog Request!!");
		
		return "/blog/blog";
	}
}
