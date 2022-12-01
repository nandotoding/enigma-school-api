package com.enigmacamp.enigmaschoolapi.service;

import com.enigmacamp.enigmaschoolapi.model.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getAll();
    Subject add(Subject subject);
}
