package org.example.demo.services.Impl;

import org.example.demo.model.Student;
import org.example.demo.repositories.IStudentRepository;
import org.example.demo.repositories.impl.StudentRepository;
import org.example.demo.services.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    private static IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        student.setId(student.getS);
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }

    @Override
    public Student findById(Long input) {
        return studentRepository.findById(input);
    }

    @Override
    public boolean update(int id, Student studentUpdate) {
        return studentRepository.update(id,studentUpdate);
    }

    @Override
    public int findIndex(Student studentUpdate) {
        return studentRepository.findIndex(studentUpdate);
    }

    @Override
    public List<Student> findByName(String searchName) {
        return studentRepository.findByName(searchName);
    }
}
