package com.enigmacamp.enigmaschoolapi.repository;

import com.enigmacamp.enigmaschoolapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, String > {
}
