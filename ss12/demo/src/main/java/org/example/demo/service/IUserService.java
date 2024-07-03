package org.example.demo.service;

import org.example.demo.models.User;
import org.example.demo.models.dto.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> selectAllUsers();



    void createUser(User user);

    void deleteUser(int id);

    void updateUser(User user);

    UserDTO findUser(int id);

    List<UserDTO> searchByName(String keyword);

    List<UserDTO> sortByName();
}
