package org.example.demo.repositories.product;

import org.example.demo.database.ConnectDB;
import org.example.demo.models.Product;
import org.example.demo.models.dto.ProductDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements IProductRepo {
    @Override
    public List<ProductDTO> selectAll() {
        List<ProductDTO> products = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select p.id,p.sku,p.name,p.unit,p.price,c.name as categorie_name,p.grown from products p join categories c on c.id = p.id_cate ";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                ProductDTO productDTO = new ProductDTO();
                productDTO.setId(rs.getInt("id"));
                productDTO.setSku(rs.getString("sku"));
                productDTO.setName(rs.getString("name"));
                productDTO.setUnit(rs.getString("unit"));
                productDTO.setPrice(rs.getDouble("price"));
                productDTO.setNameCategory(rs.getString("categorie_name"));
                productDTO.setDateReceive(rs.getString("grown"));
                products.add(productDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public void createProduct(Product product) {
        Connection connection = new ConnectDB().getConnection();
        String sql = "insert into products(sku,name,unit,price,grown,id_cate) values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,product.getSku());
            ps.setString(2,product.getName());
            ps.setString(3,product.getUnit());
            ps.setDouble(4,product.getPrice());
            ps.setString(5,product.getDateReceive());
            ps.setInt(6,product.getId_cate());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product findProductByID(int id) {
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from products where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Product product = new Product();
                product.setSku(rs.getString("sku"));
                product.setName(rs.getString("name"));
                product.setUnit(rs.getString("unit"));
                product.setPrice(rs.getDouble("price"));
                product.setDateReceive(rs.getString("grown"));
                product.setId_cate(rs.getInt("id_cate"));
                return product;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteProduct(int id) {
        Connection connection = new ConnectDB().getConnection();
        String sql = "delete from products where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> searchByName(String keyword) {
        List<Product> products = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select p.id,p.sku,p.name,p.unit,p.price,c.name as categorie_name,p.id_cate,p.grown from products p join categories c on c.id = p.id_cate where p.name like ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String sku = rs.getString("sku");
                String name = rs.getString("name");
                String unit = rs.getString("unit");
                double price = rs.getDouble("price");
                int id_cate = rs.getInt("id_cate");
                String dateReceive = rs.getString("grown");
                Product product = new Product();
                product.setId(id);
                product.setSku(sku);
                product.setName(name);
                product.setUnit(unit);
                product.setPrice(price);
                product.setId_cate(id_cate);
                product.setDateReceive(dateReceive);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public void updateProduct(Product product) {
        Connection connection = new ConnectDB().getConnection();
        String sql = "UPDATE products set sku = ?, name = ?, unit = ?, price = ?, grown = ?, id_cate = ? where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,product.getSku());
            ps.setString(2,product.getName());
            ps.setString(3,product.getUnit());
            ps.setDouble(4,product.getPrice());
            ps.setString(5,product.getDateReceive());
            ps.setInt(6,product.getId_cate());
            ps.setInt(7,product.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
