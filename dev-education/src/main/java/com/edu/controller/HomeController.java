package com.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/home1")
	public String home(Model model) {
		model.addAttribute("title","사용자가입");
		return "home";
	}
	@GetMapping("/healthy")
	public String home(Model model) {
		return "ok";
	}
}
