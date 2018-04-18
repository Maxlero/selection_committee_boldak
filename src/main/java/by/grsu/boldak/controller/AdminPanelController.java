package by.grsu.boldak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {
	@GetMapping
	public String adminPanel(Map<String, Object> model) {
		return "admin";
	}
}
