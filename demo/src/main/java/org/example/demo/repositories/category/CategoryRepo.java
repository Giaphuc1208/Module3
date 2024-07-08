package org.example.demo.repositories.category;

import org.example.demo.database.ConnectDB;
import org.example.demo.models.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepo implements ICategoryRepo{
    @Override
    public List<Category> showAllCategories() {
        List<Category> list = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from categories";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                list.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
