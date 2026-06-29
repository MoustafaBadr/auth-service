package com.mostafabadr.authservice.user.entity;

import com.mostafabadr.authservice.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

  @Column(name = "email", unique = true, length = 255)
  private String email;

  @Column(name = "mobile_number", unique = true, length = 20)
  private String mobileNumber;

  @Column(name = "password_hash", length = 255)
  private String passwordHash;

  @Column(name = "first_name", nullable = false, length = 100)
  private String firstName;

  @Column(name = "last_name", nullable = false, length = 100)
  private String lastName;

  @Column(name = "enabled", nullable = false)
  private boolean enabled;

  @Column(name = "email_verified", nullable = false)
  private boolean emailVerified;

  @Column(name = "mobile_verified", nullable = false)
  private boolean mobileVerified;
}
