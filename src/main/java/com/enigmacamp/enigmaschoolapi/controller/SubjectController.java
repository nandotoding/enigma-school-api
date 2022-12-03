package com.enigmacamp.enigmaschoolapi.controller;

import com.enigmacamp.enigmaschoolapi.exception.InvalidInputException;
import com.enigmacamp.enigmaschoolapi.exception.NotFoundException;
import com.enigmacamp.enigmaschoolapi.model.Subject;
import com.enigmacamp.enigmaschoolapi.model.request.SubjectRequest;
import com.enigmacamp.enigmaschoolapi.model.response.PagingResponse;
import com.enigmacamp.enigmaschoolapi.model.response.SuccessResponse;
import com.enigmacamp.enigmaschoolapi.service.SubjectService;
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
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity getAllSubjects() {

        List<Subject> subjects = subjectService.getAll();

        if (subjects.isEmpty()) {
            throw new NotFoundException();
        }

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Successful getting all subjects", subjects));
    }

    @PostMapping
    public ResponseEntity addSubject(@RequestBody @Valid SubjectRequest subjectRequest, BindingResult errors) {

        if (errors.hasErrors()) {
            throw new InvalidInputException();
        }

        Subject subject = modelMapper.map(subjectRequest, Subject.class);
        Subject subjectData = subjectService.add(subject);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Subject has been added successfully", subjectData));
    }

    @GetMapping("/list")
    public ResponseEntity listAllSubjects(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size,
            @RequestParam(defaultValue = "ASC") String dir,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Page<Subject> subjects = subjectService.list(page, size, dir, sortBy);

        if (subjects.isEmpty()) {
            throw new NotFoundException();
        }

        return ResponseEntity.status(HttpStatus.OK).body(new PagingResponse<>("Get subjects successfully", subjects));
    }
}
