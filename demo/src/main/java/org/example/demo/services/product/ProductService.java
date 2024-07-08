package org.example.demo.services.product;

import org.example.demo.models.Product;
import org.example.demo.models.dto.ProductDTO;
import org.example.demo.repositories.product.IProductRepo;
import org.example.demo.repositories.product.ProductRepo;
import org.example.demo.services.product.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private static IProductRepo productRepo = new ProductRepo();
    @Override
    public List<ProductDTO> selectAll() {
        return productRepo.selectAll() ;
    }

    @Override
    public void createProduct(Product product) {
        productRepo.createProduct(product);
    }

    @Override
    public Product findProductByID(int id) {
        return productRepo.findProductByID(id);
    }

    @Override
    public void deleteProduct(int id) {
        productRepo.deleteProduct(id);
    }

    @Override
    public List<Product> searchByName(String keyword) {
        return productRepo.searchByName(keyword);
    }

    @Override
    public void updateProduct(Product product) {
        productRepo.updateProduct(product);
    }
}
