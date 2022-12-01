package com.enigmacamp.enigmaschoolapi.service;

import com.enigmacamp.enigmaschoolapi.model.Lecture;

import java.util.List;

public interface LectureService {
    List<Lecture> getAll();
    Lecture add(Lecture lecture);
}
