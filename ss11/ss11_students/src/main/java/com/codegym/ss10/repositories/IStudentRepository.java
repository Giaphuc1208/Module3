package com.codegym.ss10.repositories;

import com.codegym.ss10.models.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    void save(Student student);

    Boolean deleteById(Long id);
}
