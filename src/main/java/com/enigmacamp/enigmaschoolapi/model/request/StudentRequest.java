package com.enigmacamp.enigmaschoolapi.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class StudentRequest {

    @NotBlank(message = "First Name is required")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    private String lastName;

    @NotBlank(message = "Email is required")
    private String email;
}
