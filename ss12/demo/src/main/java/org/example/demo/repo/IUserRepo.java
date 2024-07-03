package org.example.demo.repo;

import org.example.demo.models.User;
import org.example.demo.models.dto.UserDTO;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepo {
    List<UserDTO> selectAll()throws SQLException;

    void createUser(User user) throws SQLException;

    void deleteUser(int id);

    UserDTO findUser(int id) throws SQLException;

    void updateUser(User user) throws SQLException;

    List<UserDTO> searchByName(String keyword) throws SQLException;

    List<UserDTO> sortByName() throws SQLException;
}
