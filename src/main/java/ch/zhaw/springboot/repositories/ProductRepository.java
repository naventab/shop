package ch.zhaw.springboot.repositories;

import ch.zhaw.springboot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT product FROM Product product WHERE product.name LIKE ?1%")
	public List<Product> findProductByName(String productName);
}
