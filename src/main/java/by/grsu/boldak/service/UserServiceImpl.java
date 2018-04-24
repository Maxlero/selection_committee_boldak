package by.grsu.boldak.service;

import by.grsu.boldak.model.Role;
import by.grsu.boldak.model.User;
import by.grsu.boldak.repository.UserRepository;
import by.grsu.boldak.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Servise with functions for `user` table modification
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	/**
	 * Find user by Email in `user` table
	 *
	 * @param email Email as String
	 * @return User object if user exists NULL if not exists
	 */
	public User findByEmail(String email) {
		// Pass function from repository
		return userRepository.findByEmail(email);
	}

	/**
	 * Add new row to table
	 *
	 * @param registration UserRegistrationDto object which contains all required data for `user` table
	 * @return User for check if all is ok. Useless return but reqired
	 */
	public User save(UserRegistrationDto registration) {
		User user = new User();
		user.setFirstName(registration.getFirstName());
		user.setLastName(registration.getLastName());
		user.setEmail(registration.getEmail());
		user.setPassword(passwordEncoder.encode(registration.getPassword()));
		user.setFaculty(registration.getFaculty());
		user.setRoles(Arrays.asList(new Role("ROLE_USER")));
		user.setMark1(registration.getMark1());
		user.setMark2(registration.getMark2());
		user.setMark3(registration.getMark3());
		user.setCertificate(registration.getCertificate());
		user.setConfirmed(0);
		return userRepository.save(user);
	}

	/**
	 * Override method for user authentication using bcrytp caching of password
	 *
	 * @param email User email in String
	 * @return UserDetails of user account
	 * @throws UsernameNotFoundException If e-mail is incorrect
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Неверное имя пользователя или пароль");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),
				user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
	}
}
