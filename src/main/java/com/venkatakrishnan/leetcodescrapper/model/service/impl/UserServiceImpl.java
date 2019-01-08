package com.venkatakrishnan.leetcodescrapper.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venkatakrishnan.leetcodescrapper.model.User;
import com.venkatakrishnan.leetcodescrapper.model.service.UserService;
import com.venkatakrishnan.leetcodescrapper.repository.UserRepository;

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
