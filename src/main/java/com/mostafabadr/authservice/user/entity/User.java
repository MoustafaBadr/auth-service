package com.mostafabadr.authservice.user.entity;

import com.mostafabadr.authservice.authorization.entity.Role;
import com.mostafabadr.authservice.common.entity.BaseEntity;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

  private User(
      String email, String mobileNumber, String passwordHash, String firstName, String lastName) {
    this.email = email;
    this.mobileNumber = mobileNumber;
    this.passwordHash = passwordHash;
    this.firstName = firstName;
    this.lastName = lastName;

    this.enabled = true;
    this.emailVerified = false;
    this.mobileVerified = false;
  }

  @Column(name = "email", unique = true, length = 255)
  private String email;

  @Column(name = "mobile_number", unique = true, length = 20)
  private String mobileNumber;

  @Column(name = "password_hash", nullable = false, length = 255)
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

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "user_roles",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  public static User register(
      String email, String mobileNumber, String passwordHash, String firstName, String lastName) {
    return new User(email, mobileNumber, passwordHash, firstName, lastName);
  }

  public void assignRole(Role role) {
    this.roles.add(role);
  }
}
