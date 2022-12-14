package com.enigmacamp.enigmaschoolapi.controller;

import com.enigmacamp.enigmaschoolapi.model.Student;
import com.enigmacamp.enigmaschoolapi.model.response.ErrorResponse;
import com.enigmacamp.enigmaschoolapi.model.response.SuccessResponse;
import com.enigmacamp.enigmaschoolapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity getAllStudents() {
        List<Student> students = studentService.getAll();

        if (students.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("X01", "Students not found"));
        }

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Successful getting all students", students));
    }

    @PostMapping
    public ResponseEntity addStudent(@RequestBody @Valid Student student, BindingResult errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("X02", "Invalid input"));
        }

        Student s = studentService.add(student);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Student has been added successfully", s));
    }
}
