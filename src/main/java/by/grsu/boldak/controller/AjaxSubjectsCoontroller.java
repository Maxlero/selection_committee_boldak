package by.grsu.boldak.controller;

import by.grsu.boldak.model.Faculty;
import by.grsu.boldak.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller for `/AJAX/subjects` page. This page used to show facltys subjects name on registration page
 */
@Controller
@RequestMapping("/AJAX/subjects")
public class AjaxSubjectsCoontroller {
	@Autowired
	private FacultyRepository facultyRepository;

	/**
	 * Will be calld on GET requests. Returns facultys subjects names
	 *
	 * @param id Faculty id
	 * @return String page body
	 */
	@GetMapping
	@ResponseBody
	public String subjects(@RequestParam(value = "id", required = false) Integer id) {
		StringBuilder response = new StringBuilder();

		for (Faculty faculty : facultyRepository.findAll()) {
			if (faculty.getId().equals(id)) {
				response.append(faculty.getSubject1());
				response.append("\n");
				response.append(faculty.getSubject2());
				response.append("\n");
				response.append(faculty.getSubject3());
			}
		}

		return response.toString();
	}
}
