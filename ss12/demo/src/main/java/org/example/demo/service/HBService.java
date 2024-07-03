package org.example.demo.service;

import org.example.demo.models.Hobby;
import org.example.demo.repo.HBRepo;
import org.example.demo.repo.IHBRepo;

import java.sql.SQLException;
import java.util.List;

public class HBService implements IHBService{
    IHBRepo hbRepo = new HBRepo();
    @Override
    public List<Hobby> showAllHobby() {
        try {
            return hbRepo.showAllHobby();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
