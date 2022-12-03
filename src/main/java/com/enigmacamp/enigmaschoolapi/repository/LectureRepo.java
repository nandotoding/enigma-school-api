package com.enigmacamp.enigmaschoolapi.repository;

import com.enigmacamp.enigmaschoolapi.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepo extends JpaRepository<Lecture, String> {
}