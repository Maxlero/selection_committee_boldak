package by.grsu.boldak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for `/login` page. Page of authentication
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	/**
	 * Will be calld on GET requests
	 *
	 * @param model Current Model. It will be used on page frontend to show content from site backend
	 * @return String name of .html page to load
	 */
	@GetMapping
	public String login(Model model) {
		model.addAttribute("title", "Dimasos University - Sign in");

		return "login";
	}
}
