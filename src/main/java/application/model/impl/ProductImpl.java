package application.model.impl;

import application.model.product;
import java.util.Random;

public class ProductImpl implements product {
    private String name;
    private String description;
    private Double price;
    private Long iD;
    private String supplier;

    public ProductImpl(String name, String description, Double price, String supplier) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.iD = generateId();
        this.supplier = supplier;
    }

    private Long generateId() {
        Random rand = new Random();
        return rand.nextLong(20000 - 10000) + 10000;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public Integer getId() {
        return null;
    }

    @Override
    public void setId(Long iD) {
        this.iD = iD;
    }

    @Override
    public String getSupplier() {
        return this.supplier;
    }

    @Override
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
