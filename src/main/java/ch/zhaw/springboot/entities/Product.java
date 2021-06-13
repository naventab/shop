package ch.zhaw.springboot.entities;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private double price;
    private String validFrom;
    private String validTo;
    private int quantity;
    @ManyToOne
    private Supplier supplier;

    public Product(String name, String description, double price, String validFrom, String validTo, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.quantity = quantity;
        this.supplier=null;
    }

    public Product() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getValidTo() {
        return validTo;
    }

    public void setValidTo(String validTo) {
        this.validTo = validTo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Supplier getSupplier() {
        return this.supplier;
    }
}
