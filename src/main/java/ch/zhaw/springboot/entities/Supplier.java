package ch.zhaw.springboot.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String street;
	private String email;
	private String phone;
	private boolean mustBePickedUp;

	@OneToMany
	private List<Product> products;

	public Supplier(String name, String strasse, String email, String phone, boolean mustBePickedUp) {
		this.name = name;
		this.street = strasse;
		this.email = email;
		this.phone = phone;
		this.mustBePickedUp = mustBePickedUp;
	}

	public Supplier() {
		this.products = new ArrayList<Product>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String telefon) {
		this.phone = telefon;
	}

	public boolean isMustBePickedUp() {
		return mustBePickedUp;
	}

	public void setMustBePickedUp(boolean mustBePickedUp) {
		this.mustBePickedUp = mustBePickedUp;
	}
}
