package com.mostafabadr.authservice.user.api;

import com.mostafabadr.authservice.common.api.ApiPaths;
import com.mostafabadr.authservice.user.api.request.RegisterUserRequest;
import com.mostafabadr.authservice.user.api.response.RegisterUserResponse;
import com.mostafabadr.authservice.user.service.RegisterUserUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiPaths.USERS)
public class UserController {

  private final RegisterUserUseCase registerUserUseCase;

  @PostMapping(ApiPaths.REGISTER)
  @ResponseStatus(HttpStatus.CREATED)
  public RegisterUserResponse register(@Valid @RequestBody RegisterUserRequest request) {

    return registerUserUseCase.register(request);
  }
}
