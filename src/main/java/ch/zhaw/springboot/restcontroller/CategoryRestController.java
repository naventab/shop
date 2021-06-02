package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.Category;
import ch.zhaw.springboot.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryRestController {

	private static Logger log = LoggerFactory.getLogger(CategoryRestController.class);

	@Autowired
	private CategoryRepository repository;

	@RequestMapping(value = "shop/categories", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> getAllCategories() {
		List<Category> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Category>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Category>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "shop/categories/{id}", method = RequestMethod.GET)
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") long id) {
		Optional<Category> result = this.repository.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity<Category>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "shop/categories", method = RequestMethod.POST)
	public ResponseEntity<Category> createPerson(@RequestBody Category newCategory){

		Category result = this.repository.save(newCategory);
		return new ResponseEntity(result, HttpStatus.OK);
	}

	@RequestMapping(value = "shop/categories/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Category> deleteCategoryById(@PathVariable("id") long id) {
		Optional<Category> result = this.repository.findById(id);

		if (result.isPresent()) {
			repository.deleteById(id);
			log.info("was successfully deleted: " + result);
			return new ResponseEntity<Category>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		}
	}

}