package com.rest.backend.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.backend.model.AppUser;
import com.rest.backend.model.Role;
import com.rest.backend.repository.RoleRepository;
import com.rest.backend.repository.UserRepository;
import com.rest.backend.service.UserService;


import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;


// @Service
// public class UserServiceImpl implements UserService{

//   private UserRepository userRepository;


//   public UserServiceImpl(UserRepository userRepository) {
//     super();
//     this.userRepository = userRepository;
//   }

//   @Override
//   public User save(UserRegistrationDto registrationDto) {
//     User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getEmail(), registrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));

//     return userRepository.save(user);
//   }

// }
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
  private final UserRepository userRepo;
  private final RoleRepository roleRepo;


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    AppUser user = userRepo.findByUsername(username);
    if(user == null) {
      System.out.println("User not found in database");
      throw new UsernameNotFoundException("User not found in database");
    } else {
      System.out.println("User found in database");
    }

    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
    user.getRoles().forEach(role -> {
       authorities.add(new SimpleGrantedAuthority(role.getName()));
    });
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
  }


  @Override
  public void addRoleToUser(String username, String roleName) {
    AppUser user = userRepo.findByUsername(username);
    Role role = roleRepo.findByName(roleName);
    user.getRoles().add(role);
  }
  @Override
  public AppUser getUser(String username) {
    return userRepo.findByUsername(username);
  }
  @Override
  public List<AppUser> getUsers() {
    return userRepo.findAll();
  }
  @Override
  public Role saveRole(Role role) {
    return roleRepo.save(role);
  }
  @Override
  public AppUser saveUser(AppUser user) {
    return userRepo.save(user);
  }

}
