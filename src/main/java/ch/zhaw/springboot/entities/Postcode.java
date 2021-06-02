package ch.zhaw.springboot.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Postcode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int postcodeNumber;
	private String place;

	@OneToMany
	private List<Supplier> suppliers;

	public Postcode(int postcodeNumber, String place) {
		this.postcodeNumber = postcodeNumber;
		this.place = place;
	}

	public Postcode() {
		this.suppliers = new ArrayList<Supplier>();
	}

	public int getPostcodeNumber() {
		return postcodeNumber;
	}

	public String getPlace() {
		return place;
	}

}
