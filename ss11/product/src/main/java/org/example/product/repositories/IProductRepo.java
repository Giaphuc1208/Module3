package org.example.product.repositories;

import org.example.product.model.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> findAll();
    void addNewProduct(Product product);
    Product findProductById(int id);
    List<Product> searchProductByName(String name);
    void updateProduct(int id,Product product);
    void deleteProduct(int id);

}
