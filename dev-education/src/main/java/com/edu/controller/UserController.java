package com.edu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.edu.domain.User;
import com.edu.service.UserService;

//@RequiredArgsConstructor
//@RequestMapping("api/v1/user")
//@RestController
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/home")
	public String home(Model model) {
		logger.debug("intpu model {}", model);
		model.addAttribute("title", "사용자 가입 테스트");

		return "home";
	}

	@PostMapping("/addUser")
	public String addUser(User user) {
		logger.debug("user is {} ", user);
		userService.addUser(user);
		return "redirect:/users";
	}

	@GetMapping("/users")
	public String findAll(Model model) {
		logger.debug("users input = {}", model);
		
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		
		logger.debug(users.get(0).getName());
		return "users";
	}
}
