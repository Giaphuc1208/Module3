package org.example.demo.repo;

import org.example.demo.database.ConnectDB;
import org.example.demo.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepo implements IUserRepo{
    @Override
    public List<User> selectAll() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from Users";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            User user = new User();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String country = rs.getString("country");
            user.setId(id);
            user.setName(name);
            user.setEmail(email);
            user.setCountry(country);
            users.add(user);
        }
        return users;
    }

    @Override
    public void createUser(User user) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "insert into users(name,email,country) values(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,user.getName());
        ps.setString(2,user.getEmail());
        ps.setString(3,user.getCountry());
        ps.executeUpdate();
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "delete from users where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,id);
        ps.executeUpdate();
    }

    @Override
    public User findUser(int id) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from users where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String country = rs.getString("country");
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setEmail(email);
            user.setCountry(country);
            return user;
        }
        return null;
    }

    @Override
    public void updateUser(User user) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "update  users set name=?, email=? , country=? where id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,user.getName());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getCountry());
        ps.setInt(4,user.getId());
        ps.executeUpdate();
    }

    @Override
    public List<User> searchByName(String keyword) throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from users where name like ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1,"%" + keyword + "%" );
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            User user = new User();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String country = rs.getString("country");
            user.setId(id);
            user.setName(name);
            user.setEmail(email);
            user.setCountry(country);
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> sortByName() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select * from users order by name";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            User user = new User();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String country = rs.getString("country");
            user.setId(id);
            user.setName(name);
            user.setEmail(email);
            user.setCountry(country);
            users.add(user);
        }
        return users;
     }
}
