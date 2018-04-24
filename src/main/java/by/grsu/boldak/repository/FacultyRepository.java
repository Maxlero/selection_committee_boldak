package by.grsu.boldak.repository;

import by.grsu.boldak.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This will be AUTO IMPLEMENTED by Spring into a Bean called facultyRepository
 */
@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
	/**
	 * Find faculty by Id
	 *
	 * @param id Id of faculty
	 * @return Faculty or NULL if faculty not found
	 */
	Faculty findById(int id);
}
