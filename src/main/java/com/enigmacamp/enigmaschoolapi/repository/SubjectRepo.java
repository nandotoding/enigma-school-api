package com.enigmacamp.enigmaschoolapi.repository;

import com.enigmacamp.enigmaschoolapi.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, String> {
}
