package by.grsu.boldak.controller;

import by.grsu.boldak.model.User;
import by.grsu.boldak.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Main controller. It will be called on each page of site
 */
@ControllerAdvice
public class MainControllerAdvice {
	@Autowired
	private UserRepository userRepository;

	/**
	 * Main controller. It will be called on each page of site
	 *
	 * @param model Current Model. It will be used on page frontend to show content from site backend
	 */
	@ModelAttribute
	public void addBugetToModel(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();

		if (!username.equals("anonymousUser")) {
			User user = userRepository.findByEmail(username);

			model.addAttribute("account", user);
			model.addAttribute("authorized", true);
		} else {
			model.addAttribute("authorized", false);
		}

		model.addAttribute("title", "Dimasos University");
	}
}
