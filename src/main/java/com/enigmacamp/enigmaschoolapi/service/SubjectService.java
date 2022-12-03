package com.enigmacamp.enigmaschoolapi.service;

import com.enigmacamp.enigmaschoolapi.model.Subject;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SubjectService {
    List<Subject> getAll();
    Subject add(Subject subject);
    Page<Subject> list(Integer page, Integer size, String dir, String sortBy);
}
