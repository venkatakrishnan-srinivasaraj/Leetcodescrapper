package com.venkatakrishnan.leetcodescrapper.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venkatakrishnan.leetcodescrapper.model.Problem;
import com.venkatakrishnan.leetcodescrapper.model.User;
import com.venkatakrishnan.leetcodescrapper.model.UserProblemMap;
import com.venkatakrishnan.leetcodescrapper.repository.UserProblemMapRepository;
import com.venkatakrishnan.leetcodescrapper.service.UserProblemMapService;

@Service
public class UserProblemMapServiceImpl implements UserProblemMapService{
  
  @Autowired
  UserProblemMapRepository userProblemMapRepository;

  @Override
  public void saveUserProblemMap(UserProblemMap userProblemMap) {
    userProblemMapRepository.save(userProblemMap);
  }

  @Override
  public Set<UserProblemMap> getUserProblemMapByUser(User user) {
    return userProblemMapRepository.getUserProblemMapByUser(user);
  }

  @Override
  public Set<UserProblemMap> getUserProblemMapByProblem(Problem problem) {
    return userProblemMapRepository.getUserProblemMapByProblem(problem);
  }

  @Override
  public void saveSetOfUserProblemMap(Set<UserProblemMap> userProblemMap) {
    userProblemMapRepository.saveAll(userProblemMap);
  }

}
