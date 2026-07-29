package com.mostafabadr.authservice.user.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mostafabadr.authservice.common.IntegrationTest;
import com.mostafabadr.authservice.common.api.ApiPaths;
import com.mostafabadr.authservice.user.api.request.RegisterUserRequest;
import com.mostafabadr.authservice.user.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

public class UserControllerIT extends IntegrationTest {

  @Autowired private MockMvc mockMvc;

  @Autowired private ObjectMapper objectMapper;

  @Autowired private UserRepository userRepository;

  @AfterEach
  void tearDown() {
    userRepository.deleteAll();
  }

  @Test
  void shouldRegisterUserSuccessfully() throws Exception {

    RegisterUserRequest request =
        new RegisterUserRequest(
            "mostafa@example.com", "01068641938", "Password123", "Mostafa", "Badr");

    mockMvc
        .perform(
            post(ApiPaths.USERS + ApiPaths.REGISTER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.email").value("mostafa@example.com"))
        .andExpect(jsonPath("$.mobileNumber").value("01068641938"))
        .andExpect(jsonPath("$.firstName").value("Mostafa"))
        .andExpect(jsonPath("$.lastName").value("Badr"));

    assertThat(userRepository.findByEmail("mostafa@example.com")).isPresent();
  }
}
