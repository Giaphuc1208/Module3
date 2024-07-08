package org.example.demo.models;

public class Product {

    private int id;
    private String sku;
    private String name;
    private String unit;
    private double price;
    private String dateReceive;
    private String nameCategory;
    private int id_cate;

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDateReceive() {
        return dateReceive;
    }


    public void setDateReceive(String dateReceive) {
        this.dateReceive = dateReceive;
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

    public int getId_cate() {
        return id_cate;
    }

    public void setId_cate(int id_cate) {
        this.id_cate = id_cate;
    }
}

