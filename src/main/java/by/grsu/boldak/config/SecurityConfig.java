package by.grsu.boldak.config;

import by.grsu.boldak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Main security config. Thing like .htaccess in apache but for Java
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	/**
	 * Main page access configuration
	 *
	 * @param http Protocol information. Will be automaticly passed by Spring.
	 * @throws Exception Throw any exception. Do not allow to start server if smth goes wrong
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers(
						"/",
						"/entrants",
						"/AJAX/subjects",
						"/registration",
						"/js/**",
						"/css/**",
						"/img/**",
						"/webjars/**")
				.permitAll()
				.antMatchers(
						"/admin/**"
				).hasAuthority("ROLE_ADMIN")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
				.logout()
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout")
				.permitAll();
	}

	/**
	 * Create Bean for password encoding
	 *
	 * @return BCryptPasswordEncoder object
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Crate Authentication data access object bean
	 *
	 * @return DaoAuthenticationProvider
	 */
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	/**
	 * Configure created upper objects
	 *
	 * @param auth Will be automaticly passed by Spring. Menager for configuration.
	 * @throws Exception Throw any exception. Do not allow to start server if smth goes wrong
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

}