package org.example.demo.service;

import org.example.demo.models.User;
import org.example.demo.models.dto.UserDTO;
import org.example.demo.repo.IUserRepo;
import org.example.demo.repo.UserRepo;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService{
    IUserRepo userRepo = new UserRepo();
    @Override
    public List<UserDTO> selectAllUsers() {
        try {
            return userRepo.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createUser(User user) {
        try {
            userRepo.createUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUser(int id) {
            userRepo.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        try {
            userRepo.updateUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserDTO findUser(int id) {
        try {
            return  userRepo.findUser(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserDTO> searchByName(String keyword) {
        try {
            return userRepo.searchByName(keyword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserDTO> sortByName() {
        try {
            return userRepo.sortByName();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
