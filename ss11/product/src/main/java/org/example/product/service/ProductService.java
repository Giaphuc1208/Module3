package org.example.product.service;

import org.example.product.model.Product;
import org.example.product.repositories.IProductRepo;
import org.example.product.repositories.ProductRepo;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private IProductRepo iProductRepo = new ProductRepo();
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(iProductRepo.findAll());
    }

    @Override
    public void addNewProduct(Product product) {
        iProductRepo.addNewProduct(product);
    }

    @Override
    public Product findProductById(int id) {
        return iProductRepo.findProductById(id);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return iProductRepo.searchProductByName(name);
    }

    @Override
    public void updateProduct(int id, Product product) {
        iProductRepo.updateProduct(id, product);
    }

    @Override
    public void deleteProduct(int id) {
        iProductRepo.deleteProduct(id);
    }
}
