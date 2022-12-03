package com.enigmacamp.enigmaschoolapi.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SubjectRequest {

    @NotBlank(message = "Subject Name is required")
    private String subjectName;
}
