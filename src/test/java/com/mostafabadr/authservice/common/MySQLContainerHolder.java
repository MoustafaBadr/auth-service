package com.mostafabadr.authservice.common;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

public abstract class MySQLContainerHolder {

  @Container @ServiceConnection
  static final MySQLContainer<?> MYSQL = new MySQLContainer<>("mysql:8.4.6");
}
