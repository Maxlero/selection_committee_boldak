package by.grsu.boldak.controller;

import by.grsu.boldak.model.Faculty;
import by.grsu.boldak.model.Role;
import by.grsu.boldak.model.User;
import by.grsu.boldak.repository.FacultyRepository;
import by.grsu.boldak.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/entrants")
public class EntrantsController {
    @Autowired
    private UserRepository userRepository;

	@Autowired
	private FacultyRepository facultyRepository;

    private static final Logger logger = Logger.getLogger(EntrantsController.class);

    @GetMapping
    public String Entrants(Model model) {
        model.addAttribute("title", "Dimasos University - Entrants");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        if (!username.equals("anonymousUser")) {
            User user = userRepository.findByEmail(username);

            boolean admin = false;
            for (Role role : user.getRoles()) {
//                logger.info(user.getFaculty_());

                if (role.getName().equals("ROLE_ADMIN"))
                    admin = true;
            }

            model.addAttribute("admin", admin);
        } else {
            model.addAttribute("admin", false);
        }

        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);

        List<Faculty> facultys = facultyRepository.findAll();
        model.addAttribute("facultys", facultys);

        return "entrants";
    }
}
