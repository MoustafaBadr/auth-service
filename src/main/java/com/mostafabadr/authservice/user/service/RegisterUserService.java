package com.mostafabadr.authservice.user.service;

import static org.springframework.util.StringUtils.hasText;

import com.mostafabadr.authservice.authorization.entity.Role;
import com.mostafabadr.authservice.authorization.enums.RoleConstants;
import com.mostafabadr.authservice.authorization.repository.RoleRepository;
import com.mostafabadr.authservice.user.api.request.RegisterUserRequest;
import com.mostafabadr.authservice.user.api.response.RegisterUserResponse;
import com.mostafabadr.authservice.user.entity.User;
import com.mostafabadr.authservice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegisterUserService implements RegisterUserUseCase {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public RegisterUserResponse register(RegisterUserRequest request) {

    validate(request);
    Role role =
        roleRepository
            .findByName(RoleConstants.ROLE_USER)
            .orElseThrow(() -> new IllegalStateException("Default role not found."));

    String encodedPassword = passwordEncoder.encode(request.password());

    User user =
        User.register(
            request.email(),
            request.mobileNumber(),
            encodedPassword,
            request.firstName(),
            request.lastName());

    user.assignRole(role);

    User savedUser = userRepository.save(user);

    return new RegisterUserResponse(
        savedUser.getId(),
        savedUser.getEmail(),
        savedUser.getMobileNumber(),
        savedUser.getFirstName(),
        savedUser.getLastName());
  }

  private void validate(RegisterUserRequest request) {
    validateIdentifier(request);
    validateDuplicateEmail(request);
    validateDuplicateMobile(request);
  }

  private void validateIdentifier(RegisterUserRequest request) {
    if (!hasText(request.email()) && !hasText(request.mobileNumber())) {
      throw new IllegalArgumentException("Either email or mobile number must be provided.");
    }
  }

  private void validateDuplicateEmail(RegisterUserRequest request) {

    if (!hasText(request.email())) {
      return;
    }

    if (userRepository.existsByEmail(request.email())) {
      throw new IllegalArgumentException("Email already exists.");
    }
  }

  private void validateDuplicateMobile(RegisterUserRequest request) {

    if (!hasText(request.mobileNumber())) {
      return;
    }

    if (userRepository.existsByMobileNumber(request.mobileNumber())) {
      throw new IllegalArgumentException("Mobile number already exists.");
    }
  }
}
