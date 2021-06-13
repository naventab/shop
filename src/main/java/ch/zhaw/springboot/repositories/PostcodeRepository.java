package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Postcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostcodeRepository extends JpaRepository<Postcode, Long> {

}
