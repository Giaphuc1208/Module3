package org.example.demo.repo;

import org.example.demo.models.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepo {
    List<User> selectAll()throws SQLException;

    void createUser(User user) throws SQLException;

    void deleteUser(int id) throws SQLException;

    User findUser(int id) throws SQLException;

    void updateUser(User user) throws SQLException;

    List<User> searchByName(String keyword) throws SQLException;
}
