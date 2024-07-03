package org.example.demo.repo;

import org.example.demo.database.ConnectDB;
import org.example.demo.models.Hobby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HBRepo implements IHBRepo{
    @Override
    public List<Hobby> showAllHobby() throws SQLException {
        List<Hobby> hobbies = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from hobbies ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Hobby hobby = new Hobby();
            hobby.setId(rs.getInt("id"));
            hobby.setName(rs.getString("name"));
            hobbies.add(hobby);
        }
        return hobbies;
    }
}
