package by.grsu.boldak.controller;

import by.grsu.boldak.model.Faculty;
import by.grsu.boldak.model.User;
import by.grsu.boldak.repository.FacultyRepository;
import by.grsu.boldak.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Conroller for `/entrants` page
 */
@Controller
@RequestMapping("/entrants")
public class EntrantsController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FacultyRepository facultyRepository;

	private static final Logger logger = Logger.getLogger(EntrantsController.class);

	/**
	 * Will be calld on GET requests
	 *
	 * @param model Current Model. It will be used on page frontend to show content from site backend
	 * @return String name of .html page to load
	 */
	@GetMapping
	public String Entrants(Model model) {
		model.addAttribute("title", "Dimasos University - Entrants");

		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);

		List<Faculty> facultys = facultyRepository.findAll();
		model.addAttribute("facultys", facultys);

		return "entrants";
	}
}
