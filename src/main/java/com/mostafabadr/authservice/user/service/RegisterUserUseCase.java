package com.mostafabadr.authservice.user.service;

import com.mostafabadr.authservice.user.api.request.RegisterUserRequest;
import com.mostafabadr.authservice.user.api.response.RegisterUserResponse;

public interface RegisterUserUseCase {

  RegisterUserResponse register(RegisterUserRequest request);
}
