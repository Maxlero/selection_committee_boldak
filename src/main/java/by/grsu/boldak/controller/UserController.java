package by.grsu.boldak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * `user` page controller
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@GetMapping
	public String userIndex() {
		return "user/index";
	}
}
