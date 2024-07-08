package org.example.demo.models.dto;

public class ProductDTO {
    private int id;
    private String sku;
    private String name;
    private String unit;
    private double price;
    private String nameCategory;
    private String dateReceive;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getDateReceive() {
        return dateReceive;
    }

    public void setDateReceive(String dateReceive) {
        this.dateReceive = dateReceive;
    }
}
