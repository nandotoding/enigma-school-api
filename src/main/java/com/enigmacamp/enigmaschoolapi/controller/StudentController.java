package com.enigmacamp.enigmaschoolapi.controller;

import com.enigmacamp.enigmaschoolapi.exception.InvalidInputException;
import com.enigmacamp.enigmaschoolapi.exception.NotFoundException;
import com.enigmacamp.enigmaschoolapi.model.Student;
import com.enigmacamp.enigmaschoolapi.model.request.StudentRequest;
import com.enigmacamp.enigmaschoolapi.model.response.PagingResponse;
import com.enigmacamp.enigmaschoolapi.model.response.SuccessResponse;
import com.enigmacamp.enigmaschoolapi.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity getAllStudents() {

        List<Student> students = studentService.getAll();

        if (students.isEmpty()) {
            throw new NotFoundException();
        }

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Successful getting all students", students));
    }

    @PostMapping
    public ResponseEntity addStudent(@RequestBody @Valid StudentRequest studentRequest, BindingResult errors) {

        if (errors.hasErrors()) {
            throw new InvalidInputException();
        }

        Student student = modelMapper.map(studentRequest, Student.class);
        Student studentData = studentService.add(student);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Student has been added successfully", studentData));
    }

    @GetMapping("/list")
    public ResponseEntity listAllStudents(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size,
            @RequestParam(defaultValue = "ASC") String dir,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Page<Student> students = studentService.list(page, size, dir, sortBy);

        if (students.isEmpty()) {
            throw new NotFoundException();
        }

        return ResponseEntity.status(HttpStatus.OK).body(new PagingResponse<>("Get students successfully", students));
    }
}
