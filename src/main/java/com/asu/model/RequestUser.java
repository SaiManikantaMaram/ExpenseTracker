package com.asu.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestUser {
  
    @NotBlank(message="Name should not be blank")
    private String name;
    @Email(message="Please provide correct Email")
    private String email;
    @NotBlank(message="Password should not be blank")
    private String password;
    private int age;
}
