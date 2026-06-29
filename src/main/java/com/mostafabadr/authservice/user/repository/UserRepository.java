package com.mostafabadr.authservice.user.repository;

import com.mostafabadr.authservice.user.entity.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

  Optional<User> findByEmail(String email);

  Optional<User> findByMobileNumber(String mobileNumber);

  boolean existsByEmail(String email);

  boolean existsByMobileNumber(String mobileNumber);
}
