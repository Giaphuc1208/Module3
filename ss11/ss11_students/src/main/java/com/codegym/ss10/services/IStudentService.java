package com.codegym.ss10.services;

import com.codegym.ss10.models.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);

    Boolean deleteById(Long id);
}
