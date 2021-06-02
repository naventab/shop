package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Category;
import ch.zhaw.springboot.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query("SELECT pe FROM Person pe WHERE pe.birthdate = ?1")
	public List<Person> findPersonsByBirthdate(long birthdate);
}
