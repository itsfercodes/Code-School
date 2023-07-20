package com.itsfercodes.code_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itsfercodes.code_school.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
  User findByEmail(String email);
}
