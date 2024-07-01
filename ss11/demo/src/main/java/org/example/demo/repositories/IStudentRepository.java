package org.example.demo.repositories;

import org.example.demo.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    void save(Student student);

    Boolean deleteById(Long id);

    Student findById(Long input);

    boolean update(int id, Student studentUpdate);

    int findIndex(Student studentUpdate);

    List<Student> findByName(String searchName);
}
