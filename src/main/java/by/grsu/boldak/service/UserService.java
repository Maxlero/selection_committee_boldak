package by.grsu.boldak.service;

import by.grsu.boldak.model.User;
import by.grsu.boldak.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * User service used to Override some spring functions for `user` table in Datebase
 */
public interface UserService extends UserDetailsService {
	/**
	 * Find user by Email in `user` table
	 *
	 * @param email Email as String
	 * @return User object if user exists NULL if not exists
	 */
	User findByEmail(String email);

	/**
	 * Add new row to table
	 *
	 * @param registration UserRegistrationDto object which contains all required data for `user` table
	 * @return User for check if all is ok. Useless return but reqired
	 */
	User save(UserRegistrationDto registration);
}
