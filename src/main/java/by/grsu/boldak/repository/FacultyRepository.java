package by.grsu.boldak.repository;

import by.grsu.boldak.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called facultyRepository
// CRUD refers Create, Read, Update, Delete

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
	Faculty findById(int name);
}
