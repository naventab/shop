package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.Product;
import ch.zhaw.springboot.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductRestController {

	private static Logger log = LoggerFactory.getLogger(ProductRestController.class);

	@Autowired
	private ProductRepository repository;

	@RequestMapping(value = "shop/products", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Product>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "shop/products/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
		Optional<Product> result = this.repository.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity<Product>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "shop/products", method = RequestMethod.POST)
	public ResponseEntity<Product> createPerson(@RequestBody Product newProduct){

		Product result = this.repository.save(newProduct);
		return new ResponseEntity(result, HttpStatus.OK);
	}

	@RequestMapping(value = "shop/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Product> deleteProductById(@PathVariable("id") long id) {
		Optional<Product> result = this.repository.findById(id);

		if (result.isPresent()) {
			repository.deleteById(id);
			log.info("was successfully deleted: " + result);
			return new ResponseEntity<Product>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "shop/products/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<Product> updateProductDetailsById(@PathVariable("id") long id, @RequestBody Product newProduct) {
		Optional<Product> result = this.repository.findById(id);
		log.info("was found: " + result);
		if (result.isPresent()) {
			repository.save(newProduct);
			return new ResponseEntity<Product>(result.get(), HttpStatus.OK);
		} else {

			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}

}