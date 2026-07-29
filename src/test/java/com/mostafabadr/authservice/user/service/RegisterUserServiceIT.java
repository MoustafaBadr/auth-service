package com.mostafabadr.authservice.user.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.mostafabadr.authservice.common.IntegrationTest;
import com.mostafabadr.authservice.user.api.request.RegisterUserRequest;
import com.mostafabadr.authservice.user.entity.User;
import com.mostafabadr.authservice.user.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

class RegisterUserServiceIT extends IntegrationTest {

  @Autowired private RegisterUserUseCase registerUserUseCase;

  @Autowired private UserRepository userRepository;

  @AfterEach
  void tearDown() {
    userRepository.deleteAll();
  }

  @Test
  void shouldThrowExceptionWhenEmailAlreadyExists() {
    userRepository.save(
        User.register("existing@example.com", "01111111111", "encoded", "Existing", "User"));

    RegisterUserRequest request =
        new RegisterUserRequest("existing@example.com", "01222222222", "password", "New", "User");

    assertThatThrownBy(() -> registerUserUseCase.register(request))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Email already exists.");
  }

  @Test
  void shouldThrowExceptionWhenMobileNumberAlreadyExists() {
    userRepository.save(
        User.register("other@example.com", "01111111111", "encoded", "Existing", "User"));

    RegisterUserRequest request =
        new RegisterUserRequest("new@example.com", "01111111111", "password", "New", "User");

    assertThatThrownBy(() -> registerUserUseCase.register(request))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Mobile number already exists.");
  }

  @Test
  void shouldThrowExceptionWhenEmailAndMobileAreMissing() {
    RegisterUserRequest request =
        new RegisterUserRequest(null, null, "password", "No", "Identifier");

    assertThatThrownBy(() -> registerUserUseCase.register(request))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Either email or mobile number must be provided.");
  }

  @Test
  @Sql(scripts = "/sql/delete-roles.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
  @Sql(
      scripts = "/sql/restore-default-roles.sql",
      executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
  void shouldThrowExceptionWhenDefaultRoleDoesNotExist() {
    RegisterUserRequest request =
        new RegisterUserRequest("new@example.com", "01111111111", "password", "New", "User");

    assertThatThrownBy(() -> registerUserUseCase.register(request))
        .isInstanceOf(IllegalStateException.class)
        .hasMessage("Default role not found.");
  }
}
