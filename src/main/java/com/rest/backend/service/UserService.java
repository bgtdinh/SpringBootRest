package com.rest.backend.service;

import java.util.List;

import com.rest.backend.model.AppUser;
import com.rest.backend.model.Role;


public interface UserService {
  // User save(UserRegistrationDto registrationDto);
  AppUser saveUser(AppUser user);
  Role saveRole(Role role);
  void addRoleToUser(String username, String roleName);
  AppUser getUser(String username);
  List<AppUser> getUsers();
}
