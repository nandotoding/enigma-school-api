package com.enigmacamp.enigmaschoolapi.service;

import com.enigmacamp.enigmaschoolapi.model.Lecture;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LectureService {
    List<Lecture> getAll();
    Lecture add(Lecture lecture);
    Page<Lecture> list(Integer page, Integer size, String dir, String sortBy);
}
