package com.venkatakrishnan.leetcodescrapper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venkatakrishnan.leetcodescrapper.model.User;
import com.venkatakrishnan.leetcodescrapper.repository.UserRepository;
import com.venkatakrishnan.leetcodescrapper.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  
  @Autowired
  UserRepository userRepository;

  @Override
  public void saveUser(User user) {
    userRepository.save(user);
  }

  @Override
  public User getUser(int userId) {
    return userRepository.getUserById(userId);
  }

  @Override
  public User getUser(String userName) {
     return userRepository.getUserByUsername(userName);
  }

}
