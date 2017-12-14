package org.zzingobomi.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;

@RestController
@Log
public class SampleController {

	/*
	@GetMapping("/hello")	
	public JSONObject sayHello() throws JSONException {
		
		log.info("Hello Request!");
		
		JSONObject json = new JSONObject();
		json.put("result", "Hello JongChan, Bomi. I'm Crazy Happy");

		return json;
		
		//return "Hello JongChan, Bomi. I'm Crazy Happy";
	}
	*/
}
