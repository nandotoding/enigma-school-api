package com.enigmacamp.enigmaschoolapi.controller;

import com.enigmacamp.enigmaschoolapi.exception.InvalidInputException;
import com.enigmacamp.enigmaschoolapi.exception.NotFoundException;
import com.enigmacamp.enigmaschoolapi.model.Lecture;
import com.enigmacamp.enigmaschoolapi.model.request.LectureRequest;
import com.enigmacamp.enigmaschoolapi.model.response.SuccessResponse;
import com.enigmacamp.enigmaschoolapi.service.LectureService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class LectureController {

    @Autowired
    private LectureService lectureService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity getAllLecture() {

        List<Lecture> lectures = lectureService.getAll();

        if (lectures.isEmpty()) {
            throw new NotFoundException();
        }

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Successful getting all lectures", lectures));
    }

    @PostMapping
    public ResponseEntity addLecture(@RequestBody @Valid LectureRequest lectureRequest, BindingResult errors) {

        if (errors.hasErrors()) {
            throw new InvalidInputException();
        }

        Lecture lecture = modelMapper.map(lectureRequest, Lecture.class);
        Lecture lectureData = lectureService.add(lecture);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Lecture has been added successfully", lectureData));
    }
}
