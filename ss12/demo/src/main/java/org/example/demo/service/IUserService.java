package org.example.demo.service;

import org.example.demo.models.User;

import java.util.List;

public interface IUserService {
    List<User> selectAllUsers();



    void createUser(User user);

    void deleteUser(int id);

    void updateUser(User user);

    User findUser(int id);

    List<User> searchByName(String keyword);

    List<User> sortByName();
}
