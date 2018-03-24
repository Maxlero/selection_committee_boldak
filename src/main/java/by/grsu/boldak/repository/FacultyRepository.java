package by.grsu.boldak.repository;

import by.grsu.boldak.model.Faculty;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called facultyRepository
// CRUD refers Create, Read, Update, Delete

public interface FacultyRepository extends CrudRepository<Faculty, Long> {
	Faculty findById(Integer name);
}
