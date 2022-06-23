package com.rest.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.backend.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
  AppUser findByUsername(String username);
}
