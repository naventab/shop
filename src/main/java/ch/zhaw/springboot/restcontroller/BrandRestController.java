package ch.zhaw.springboot.restcontroller;

import ch.zhaw.springboot.entities.Brand;
import ch.zhaw.springboot.entities.Product;
import ch.zhaw.springboot.repositories.BrandRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class BrandRestController {

	private static Logger log = LoggerFactory.getLogger(BrandRestController.class);

	@Autowired
	private BrandRepository repository;

	@RequestMapping(value = "shop/brands", method = RequestMethod.GET)
	public ResponseEntity<List<Brand>> getAllbrands() {
		List<Brand> result = this.repository.findAll();

		if (!result.isEmpty()) {
			return new ResponseEntity<List<Brand>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Brand>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "shop/brands/{id}", method = RequestMethod.GET)
	public ResponseEntity<Brand> getBrandById(@PathVariable("id") long id) {
		Optional<Brand> result = this.repository.findById(id);

		if (result.isPresent()) {
			return new ResponseEntity<Brand>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Brand>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "shop/brands", method = RequestMethod.POST)
	public ResponseEntity<Brand> createNewBrand(@RequestBody Brand newBrand){

		Brand result = this.repository.save(newBrand);
		return new ResponseEntity(result, HttpStatus.OK);
	}

	@RequestMapping(value = "shop/brand/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Brand> deleteBrandById(@PathVariable("id") long id) {
		Optional<Brand> result = this.repository.findById(id);

		if (result.isPresent()) {
			repository.deleteById(id);
			log.info("was successfully deleted: " + result);
			return new ResponseEntity<Brand>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Brand>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(value = "shop/brands/{id}/products",method = RequestMethod.GET)
			public ResponseEntity<List<Product>> getProductsByBrandId(@PathVariable ("id") long id)
	{
		List<Product> result = this.repository.findProductsByBrandId(id);
		if(!result.isEmpty()){
			return new ResponseEntity<List<Product>>(result, HttpStatus.OK);
		}else{
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(value = "shop/brands/{name}/products",method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProductsByBrandId(@PathVariable ("name") String name)
	{
		List<Product> result = this.repository.findProductsByBrandName(name);
		if(!result.isEmpty()){
			return new ResponseEntity<List<Product>>(result, HttpStatus.OK);
		}else{
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(value = "shop/brands/name/{name}",method = RequestMethod.GET)
	public ResponseEntity<List<Brand>> getBrandsByName(@PathVariable ("name") String name)
	{
		List<Brand> result = this.repository.findBrandsByName(name);
		if(!result.isEmpty()){
			return new ResponseEntity<List<Brand>>(result, HttpStatus.OK);
		}else{
			return new ResponseEntity<List<Brand>>(HttpStatus.NOT_FOUND);
		}
	}
}