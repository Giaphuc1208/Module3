package org.example.product.repositories;

import org.example.product.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepo implements IProductRepo{
    private static Map<Integer, Product> productsMap;

    static {
        productsMap = new HashMap<>();
        productsMap.put(1, new Product(1, "Accent", 1200, "Car", "Hyundai"));
        productsMap.put(2, new Product(2, "Elantra", 1000, "Car", "Hyundai"));
        productsMap.put(3, new Product(3, "Mec-Maybach", 1500, "Car", "Mec"));
        productsMap.put(4, new Product(4, "Mec-G63", 2200, "Car", "Mec"));
        productsMap.put(5, new Product(5, "VinFast", 20000, "Car", "VinGroup"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productsMap.values());
    }

    @Override
    public void addNewProduct(Product product) {
        productsMap.put(product.getId(), product);
    }

    @Override
    public Product findProductById(int id) {
        return productsMap.get(id);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        List<Product> productList = findAll();
        List<Product> results = new ArrayList<>();
        for (Product product : productList) {
            if (product.getProductName().equals(name))
                results.add(product);
        }
        return results;
    }

    @Override
    public void updateProduct(int id, Product product) {
        productsMap.put(id, product);
    }

    @Override
    public void deleteProduct(int id) {
        productsMap.remove(id);
    }
}
