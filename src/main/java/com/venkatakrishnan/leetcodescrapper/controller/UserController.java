package com.venkatakrishnan.leetcodescrapper.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.venkatakrishnan.leetcodescrapper.exception.ResourceNotFoundException;
import com.venkatakrishnan.leetcodescrapper.model.User;
import com.venkatakrishnan.leetcodescrapper.repository.UserRepository;

@RestController
public class UserController {

  @Autowired
  UserRepository userRepository;

  @GetMapping("/users")
  public Page<User> getAllUsers(Pageable pageable) {
    return userRepository.findAll(pageable);
  }

  @PostMapping("/users")
  public User createUser(@Valid @RequestBody User user) {
    return userRepository.save(user);
  }

  @PutMapping("/users/{userId}")
  public User updateUser(@PathVariable Long userId, @Valid @RequestBody User userRequest) {
    return userRepository.findById(userId).map(user -> {
      user.setUsername(userRequest.getUsername());
      user.setEmail(userRequest.getEmail());
      user.setPassword(userRequest.getPassword());
      return userRepository.save(user);
    }).orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found"));
  }


  @DeleteMapping("/users/{userId}")
  public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
    return userRepository.findById(userId).map(user -> {
      userRepository.delete(user);
      return ResponseEntity.ok().build();
    }).orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found"));
  }


}
