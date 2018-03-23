package by.grsu.boldak.controllers;

import by.grsu.boldak.Starter;
import by.grsu.boldak.models.AuthenticateForm;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
	private static final Logger logger = Logger.getLogger(AuthController.class);

	@GetMapping("/auth")
	public String authForm(Model model) {
		model.addAttribute("error", false);
		model.addAttribute("auth", new AuthenticateForm());

		return "/auth";
	}

	@PostMapping("/auth")
	public String authSubmit(@ModelAttribute AuthenticateForm auth, Model model) {
		model.addAttribute("auth", auth);
		model.addAttribute("error", true);

		logger.info(auth.getUsername());
		logger.info(auth.getPassword());
		logger.info(auth.isSavePass());

		return "/auth";
	}
}
