package com.mostafabadr.authservice.user.api.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterUserRequest(
    @Email String email,
    String mobileNumber,
    @NotBlank String password,
    @NotBlank String firstName,
    @NotBlank String lastName) {}
