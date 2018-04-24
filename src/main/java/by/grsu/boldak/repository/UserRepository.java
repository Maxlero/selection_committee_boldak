package by.grsu.boldak.repository;

import by.grsu.boldak.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This will be AUTO IMPLEMENTED by Spring into a Bean called facultyRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	/**
	 * Find User by e-mail
	 *
	 * @param email e-mail as String
	 * @return User or NULL if user not found
	 */
	User findByEmail(String email);
}
