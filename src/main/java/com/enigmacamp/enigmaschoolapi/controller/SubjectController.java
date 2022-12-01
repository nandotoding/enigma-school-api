package com.enigmacamp.enigmaschoolapi.controller;

import com.enigmacamp.enigmaschoolapi.model.Subject;
import com.enigmacamp.enigmaschoolapi.model.response.ErrorResponse;
import com.enigmacamp.enigmaschoolapi.model.response.SuccessResponse;
import com.enigmacamp.enigmaschoolapi.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping
    public ResponseEntity getAllSubjects() {
        List<Subject> subjects = subjectService.getAll();

        if (subjects.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("X01", "Subjects not found"));
        }

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Successful getting all subjects", subjects));
    }

    @PostMapping
    public ResponseEntity addSubject(@RequestBody @Valid Subject subject, BindingResult errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("X02", "Invalid input"));
        }

        Subject s = subjectService.add(subject);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Subject has been added successfully", s));
    }
}
