package org.example.demo.service;

import org.example.demo.models.User;
import org.example.demo.repo.IUserRepo;
import org.example.demo.repo.UserRepo;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService{
    IUserRepo userRepo = new UserRepo();
    @Override
    public List<User> selectAllUsers() {
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
        try {
            userRepo.deleteUser(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
    public User findUser(int id) {
        try {
            return  userRepo.findUser(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> searchByName(String keyword) {
        try {
            return userRepo.searchByName(keyword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> sortByName() {
        try {
            return userRepo.sortByName();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
