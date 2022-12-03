package com.enigmacamp.enigmaschoolapi.service;

import com.enigmacamp.enigmaschoolapi.model.Student;
import com.enigmacamp.enigmaschoolapi.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student add(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Page<Student> list(Integer page, Integer size, String dir, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.valueOf(dir), sortBy);
        Pageable pageable = PageRequest.of((page - 1), size, sort);
        return studentRepo.findAll(pageable);
    }
}
