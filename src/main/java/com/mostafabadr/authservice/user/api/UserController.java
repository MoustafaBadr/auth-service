package com.mostafabadr.authservice.user.api;

import com.mostafabadr.authservice.common.api.ApiPaths;
import com.mostafabadr.authservice.common.api.ApiTags;
import com.mostafabadr.authservice.user.api.request.RegisterUserRequest;
import com.mostafabadr.authservice.user.api.response.RegisterUserResponse;
import com.mostafabadr.authservice.user.service.RegisterUserUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiPaths.USERS)
@Tag(name = ApiTags.USERS, description = "User management APIs")
public class UserController {

  private final RegisterUserUseCase registerUserUseCase;

  @PostMapping(ApiPaths.REGISTER)
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Register a new user",
      description = "Creates a new user account using email or mobile number.")
  public RegisterUserResponse register(@Valid @RequestBody RegisterUserRequest request) {

    return registerUserUseCase.register(request);
  }
}
