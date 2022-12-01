package com.enigmacamp.enigmaschoolapi.service;

import com.enigmacamp.enigmaschoolapi.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student add(Student student);
}
