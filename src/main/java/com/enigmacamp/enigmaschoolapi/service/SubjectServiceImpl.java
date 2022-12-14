package com.enigmacamp.enigmaschoolapi.service;

import com.enigmacamp.enigmaschoolapi.model.Subject;
import com.enigmacamp.enigmaschoolapi.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepo subjectRepo;

    @Autowired
    public SubjectServiceImpl(SubjectRepo subjectRepo) {
        this.subjectRepo = subjectRepo;
    }

    @Override
    public List<Subject> getAll() {
        return subjectRepo.findAll();
    }

    @Override
    public Subject add(Subject subject) {
        return subjectRepo.save(subject);
    }
}
