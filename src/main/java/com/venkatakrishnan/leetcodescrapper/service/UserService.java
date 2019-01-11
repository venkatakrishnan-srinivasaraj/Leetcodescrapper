package com.venkatakrishnan.leetcodescrapper.service;

import org.springframework.stereotype.Service;

import com.venkatakrishnan.leetcodescrapper.model.User;

@Service
public interface UserService {

  public void saveUser(User user);
  
  public User getUser(int userId);
  
  public User getUser(String username);
  
}
