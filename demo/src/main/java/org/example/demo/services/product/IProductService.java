package org.example.demo.services.product;

import org.example.demo.models.Product;
import org.example.demo.models.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> selectAll();

    void createProduct(Product product);

    Product findProductByID(int id);

    void deleteProduct(int id);

    List<Product> searchByName(String keyword);

    void updateProduct(Product product);
}
