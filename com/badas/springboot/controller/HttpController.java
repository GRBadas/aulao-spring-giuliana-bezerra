package com.badas.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpController {
	
	@GetMapping("/public")
	public String publicRoute() {
		return "<h1> Public route, feel free to look around :) </h1>";
	}
	
	@GetMapping("/private")
	public String privateRoute() {
		return "<h1> Private route, only authorized personal >:( </h1>";
	}

}
