package by.grsu.boldak.controller;

import by.grsu.boldak.model.AdminSubmit;
import by.grsu.boldak.model.Faculty;
import by.grsu.boldak.model.User;
import by.grsu.boldak.repository.FacultyRepository;
import by.grsu.boldak.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Conroller for `/admin` page
 */
@Controller
@RequestMapping("/admin")
public class AdminPanelController {
	private static final Logger logger = Logger.getLogger(AdminPanelController.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FacultyRepository facultyRepository;

	/**
	 * Create model for form on page. Model was named as `adminSubmit`
	 *
	 * @return new Model object
	 */
	@ModelAttribute("adminSubmit")
	public AdminSubmit adminSubmit() {
		return new AdminSubmit();
	}

	/**
	 * Will be calld on GET requests
	 *
	 * @param model Current Model. It will be used on page frontend to show content from site backend
	 * @return String name of .html page to load
	 */
	@GetMapping
	public String adminPanel(Model model) {
		model.addAttribute("title", "Dimasos University - Admins room");

		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);

		List<Faculty> facultys = facultyRepository.findAll();
		model.addAttribute("facultys", facultys);

		return "admin";
	}

	/**
	 * Will be calld on POST requests
	 *
	 * @param adminSubmit Form data model from `/admin` page
	 * @return String name of .html page to load
	 */
	@PostMapping
	public String adminPanelPost(@ModelAttribute("adminSubmit") AdminSubmit adminSubmit) {
		if (adminSubmit.getType().equals("accept") || adminSubmit.getType().equals("decline")) {
			User user = userRepository.findByEmail(adminSubmit.getEmail());

			if (user != null) {
				if (adminSubmit.getType().equals("accept"))
					user.setConfirmed(1);

				if (adminSubmit.getType().equals("decline"))
					user.setConfirmed(-1);

				userRepository.save(user);
			}
		}

		return "redirect:/admin";
	}
}
