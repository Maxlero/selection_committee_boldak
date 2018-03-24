package by.grsu.boldak.service;

import by.grsu.boldak.model.User;
import by.grsu.boldak.DataTransferObject.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	User findByEmail(String email);

	User save(UserRegistrationDto registration);
}
