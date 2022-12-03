package com.enigmacamp.enigmaschoolapi.service;

import com.enigmacamp.enigmaschoolapi.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student add(Student student);
    Page<Student> list(Integer page, Integer size, String dir, String sortBy);
}
