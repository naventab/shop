package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Person;
import ch.zhaw.springboot.entities.Postcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostcodeRepository extends JpaRepository<Postcode, Long> {

	@Query("SELECT pe FROM Person pe WHERE pe.birthdate = ?1")
	public List<Person> findPersonsByBirthdate(long birthdate);
}
