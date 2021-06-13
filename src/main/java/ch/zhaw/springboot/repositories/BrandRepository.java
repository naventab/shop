package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Brand;
import ch.zhaw.springboot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {

	@Query("SELECT b FROM Brand b WHERE b.id = ?1")
	public Optional<Brand> findBrandById(long birthdate);
	@Query("SELECT b FROM Brand b WHERE b.name=?1")
	public Optional<Brand> findBrandByName(String name);
	@Query("Select  p.products from Brand p WHERE p.id=?1 ")
	public List<Product> findProductsByBrandId(long id);
	@Query("Select  p.products from Brand p WHERE p.name=?1 ")
	public List<Product> findProductsByBrandName(String name);
	@Query ("SELECT b from Brand b where b.name = ?1")
	public List<Brand> findBrandsByName(String name);

}
