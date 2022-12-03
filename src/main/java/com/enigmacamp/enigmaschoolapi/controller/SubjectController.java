package com.enigmacamp.enigmaschoolapi.controller;

import com.enigmacamp.enigmaschoolapi.exception.InvalidInputException;
import com.enigmacamp.enigmaschoolapi.exception.NotFoundException;
import com.enigmacamp.enigmaschoolapi.model.Subject;
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
            throw new NotFoundException();
        }

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Successful getting all subjects", subjects));
    }

    @PostMapping
    public ResponseEntity addSubject(@RequestBody @Valid Subject subject, BindingResult errors) {

        if (errors.hasErrors()) {
            throw new InvalidInputException();
        }

        Subject s = subjectService.add(subject);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Subject has been added successfully", s));
    }
}
