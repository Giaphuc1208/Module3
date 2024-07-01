package org.example.demo.repositories.impl;

import org.example.demo.model.Student;
import org.example.demo.repositories.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List<Student> students;

    static {
        students = new ArrayList<>();
        students.add(new Student(1L, "haiTT", "QN", 10.0f));
        students.add(new Student(2L, "Bảo Ngọc", "HN", 8.0f));
        students.add(new Student(3L, "Bảo Kỳ", "DN", 6.0f));
        students.add(new Student(5L, "Cook", "Bàn ăn", 2f));
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void save(Student student) {
        student.setId(students.get(students.size() - 1).getId() + 1);
        students.add(student);
    }

    @Override
    public Boolean deleteById(Long id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    @Override
    public Student findById(Long input) {
        for (Student student : students) {
            if (student.getId().equals(input)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public boolean update(int id, Student studentUpdate) {
        students.set(id, studentUpdate);
        return true;
    }

    @Override
    public int findIndex(Student studentUpdate) {
        for (Student student : students) {
            if (student.getId().equals(studentUpdate.getId())) {
                return students.indexOf(student);
            }
        }
        return -1;
    }

    @Override
    public List<Student> findByName(String searchName) {
        List<Student> foundStudents = new ArrayList<>();

        if (searchName == null || searchName.trim().isEmpty()) {
            return  foundStudents;
        }

        String search = searchName.trim().toLowerCase();
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(search)) {
                foundStudents.add(student);
            }
        }

        if (foundStudents.isEmpty()) {
            return null;
        }

        return  foundStudents;
    }

}
