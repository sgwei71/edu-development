package com.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//@Controller
@RequestMapping("api/v1/")
@RestController
public class HomeController {
	@GetMapping("/home1")
	public String home(Model model) {
		model.addAttribute("title","사용자가입");
		return "home";
	}
	
	@GetMapping("/healthy")
	public String healthy(Model model) {
		return "ok";
	}
}
