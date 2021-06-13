package ch.zhaw.springboot.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany
    private List<Product> products;

    public Brand(String name) {

        this.name = name;
        this.products = new ArrayList<Product>();
    }

    public Brand() {
        this.products = new ArrayList<Product>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return this.id;
    }

    public List<Product> getProducts() {
        return this.products;
    }
}
