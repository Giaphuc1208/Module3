package org.example.demo.repo;

import org.example.demo.database.ConnectDB;
import org.example.demo.models.User;
import org.example.demo.models.dto.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepo implements IUserRepo{
    @Override
    public List<UserDTO> selectAll() throws SQLException {
        List<UserDTO> users = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "select users.id,users.name,users.email,users.country,hobbies.name as hobby from users join hobbies on hobbies.id = users.id_hb";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            UserDTO user = new UserDTO();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String country = rs.getString("country");
            String hobby = rs.getString("hobby");
            user.setId(id);
            user.setName(name);
            user.setEmail(email);
            user.setCountry(country);
            user.setHobby(hobby);
            users.add(user);
        }
        return users;
    }

    @Override
    public void createUser(User user) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "insert into users(name,email,country,id_hb) values(?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,user.getName());
        ps.setString(2,user.getEmail());
        ps.setString(3,user.getCountry());
        ps.setInt(4,user.getIdHobby());
        ps.executeUpdate();
    }

    @Override
    public void deleteUser(int id)  {
        Connection connection = null;
        try{
            connection = new ConnectDB().getConnection();
            connection.setAutoCommit(false);
            String sql = "delete from users where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e){
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }


    }

    @Override
    public UserDTO findUser(int id) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "SELECT users.id, users.name, users.email, users.country, hobbies.name AS hobby " +
                "FROM users " +
                "JOIN hobbies ON hobbies.id = users.id_hb " +
                "WHERE users.id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int userId = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String country = rs.getString("country");
            String hobby = rs.getString("hobby");

            UserDTO user = new UserDTO();
            user.setId(userId);
            user.setName(name);
            user.setEmail(email);
            user.setCountry(country);
            user.setHobby(hobby);
            return user;
        }
        return null;
    }

    @Override
    public void updateUser(User user) throws SQLException {
        Connection connection = new ConnectDB().getConnection();
        String sql = "UPDATE users SET name = ?, email = ?, country = ?, id_hb = ? WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, user.getName());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getCountry());
        ps.setInt(4, user.getIdHobby());
        ps.setInt(5, user.getId());
        ps.executeUpdate();
    }


    @Override
    public List<UserDTO> searchByName(String keyword) throws SQLException {
        List<UserDTO> users = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "SELECT users.id, users.name, users.email, users.country, hobbies.name AS hobby FROM users JOIN hobbies ON hobbies.id = users.id_hb WHERE users.name LIKE ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, "%" + keyword + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            UserDTO user = new UserDTO();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String country = rs.getString("country");
            String hobby = rs.getString("hobby");
            user.setId(id);
            user.setName(name);
            user.setEmail(email);
            user.setCountry(country);
            user.setHobby(hobby);
            users.add(user);
        }
        return users;
    }


    @Override
    public List<UserDTO> sortByName() throws SQLException {
        List<UserDTO> users = new ArrayList<>();
        Connection connection = new ConnectDB().getConnection();
        String sql = "SELECT users.id, users.name, users.email, users.country, hobbies.name AS hobby FROM users JOIN hobbies ON hobbies.id = users.id_hb ORDER BY users.name";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            UserDTO user = new UserDTO();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String country = rs.getString("country");
            String hobby = rs.getString("hobby");
            user.setId(id);
            user.setName(name);
            user.setEmail(email);
            user.setCountry(country);
            user.setHobby(hobby);
            users.add(user);
        }
        return users;
    }

}
