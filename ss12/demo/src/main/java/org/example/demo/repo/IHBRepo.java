package org.example.demo.repo;

import org.example.demo.models.Hobby;

import java.sql.SQLException;
import java.util.List;

public interface IHBRepo {
    List<Hobby> showAllHobby() throws SQLException;
}
