package com.mostafabadr.authservice.user.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.mostafabadr.authservice.common.RepositoryIntegrationTest;
import com.mostafabadr.authservice.user.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class UserRepositoryIT extends RepositoryIntegrationTest {

  @Autowired private UserRepository userRepository;

  @BeforeEach
  void setUp() {
    userRepository.save(
        User.register("mostafa@example.com", "01068641938", "encoded-password", "Mostafa", "Badr"));
  }

  @AfterEach
  void tearDown() {
    userRepository.deleteAll();
  }

  @Test
  void shouldSaveUser() {
    User saved =
        userRepository.save(
            User.register("ali@example.com", "01087654321", "encoded", "Ali", "Khan"));

    assertThat(saved.getId()).isNotNull();
    assertThat(saved.getEmail()).isEqualTo("ali@example.com");
    assertThat(saved.getMobileNumber()).isEqualTo("01087654321");
    assertThat(saved.isEnabled()).isTrue();
    assertThat(saved.isEmailVerified()).isFalse();
    assertThat(saved.isMobileVerified()).isFalse();
    assertThat(saved.getCreatedAt()).isNotNull();
    assertThat(saved.getUpdatedAt()).isNotNull();
  }

  @Test
  void shouldFindUserByEmail() {
    var found = userRepository.findByEmail("mostafa@example.com");

    assertThat(found).isPresent();
    assertThat(found.get().getEmail()).isEqualTo("mostafa@example.com");
  }

  @Test
  void shouldReturnEmptyWhenEmailDoesNotExist() {
    var found = userRepository.findByEmail("unknown@example.com");

    assertThat(found).isEmpty();
  }

  @Test
  void shouldReturnTrueWhenEmailExists() {
    boolean exists = userRepository.existsByEmail("mostafa@example.com");

    assertThat(exists).isTrue();
  }

  @Test
  void shouldReturnFalseWhenEmailDoesNotExist() {
    boolean exists = userRepository.existsByEmail("unknown@example.com");

    assertThat(exists).isFalse();
  }

  @Test
  void shouldReturnTrueWhenMobileNumberExists() {
    boolean exists = userRepository.existsByMobileNumber("01068641938");

    assertThat(exists).isTrue();
  }

  @Test
  void shouldReturnFalseWhenMobileNumberDoesNotExist() {
    boolean exists = userRepository.existsByMobileNumber("01000000000");

    assertThat(exists).isFalse();
  }

  @Test
  void shouldFindUserByMobileNumber() {
    var found = userRepository.findByMobileNumber("01068641938");

    assertThat(found).isPresent();
    assertThat(found.get().getMobileNumber()).isEqualTo("01068641938");
  }
}
