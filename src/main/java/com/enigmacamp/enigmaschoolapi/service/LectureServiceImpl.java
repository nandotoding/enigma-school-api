package com.enigmacamp.enigmaschoolapi.service;

import com.enigmacamp.enigmaschoolapi.model.Lecture;
import com.enigmacamp.enigmaschoolapi.repository.LectureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureServiceImpl implements LectureService {
    private final LectureRepo lectureRepo;

    @Autowired
    public LectureServiceImpl(LectureRepo lectureRepo) {
        this.lectureRepo = lectureRepo;
    }

    @Override
    public List<Lecture> getAll() {
        return lectureRepo.findAll();
    }

    @Override
    public Lecture add(Lecture lecture) {
        return lectureRepo.save(lecture);
    }

    @Override
    public Page<Lecture> list(Integer page, Integer size, String dir, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.valueOf(dir), sortBy);
        Pageable pageable = PageRequest.of((page - 1), size, sort);
        return lectureRepo.findAll(pageable);
    }
}
