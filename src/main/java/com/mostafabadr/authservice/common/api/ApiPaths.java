package com.mostafabadr.authservice.common.api;

public final class ApiPaths {

  private ApiPaths() {}

  public static final String API_V1 = "/api/v1";

  // Resources
  public static final String USERS = API_V1 + "/users";
  public static final String AUTH = API_V1 + "/auth";
  public static final String OTP = API_V1 + "/otp";

  // User endpoints
  public static final String REGISTER = "/register";
}
