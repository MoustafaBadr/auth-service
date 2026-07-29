package com.mostafabadr.authservice.user.api.response;

import java.util.UUID;

public record RegisterUserResponse(
    UUID id, String email, String mobileNumber, String firstName, String lastName) {}
