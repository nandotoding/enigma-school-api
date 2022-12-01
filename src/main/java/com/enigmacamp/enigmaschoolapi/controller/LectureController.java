package com.enigmacamp.enigmaschoolapi.controller;

import com.enigmacamp.enigmaschoolapi.model.Lecture;
import com.enigmacamp.enigmaschoolapi.model.response.ErrorResponse;
import com.enigmacamp.enigmaschoolapi.model.response.SuccessResponse;
import com.enigmacamp.enigmaschoolapi.service.LectureService;
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

    @GetMapping
    public ResponseEntity getAllLecture() {
        List<Lecture> lectures = lectureService.getAll();

        if (lectures.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("X01", "Lectures not found"));
        }

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Successful getting all lectures", lectures));
    }

    @PostMapping
    public ResponseEntity addLecture(@RequestBody @Valid Lecture lecture, BindingResult errors) throws Exception {
        if (errors.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("X02", "Invalid input"));
        }

        Lecture l = lectureService.add(lecture);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Lecture has been added successfully", l));
    }
}
