package com.mostafabadr.authservice.authorization.entity;

import com.mostafabadr.authservice.common.entity.BaseEntity;
import com.mostafabadr.authservice.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "roles")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Role extends BaseEntity {

  @Column(nullable = false, unique = true, length = 50)
  private String name;

  @Column(length = 255)
  private String description;

  @ManyToMany(mappedBy = "roles")
  private Set<User> users = new HashSet<>();
}
