package com.venkatakrishnan.leetcodescrapper.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.venkatakrishnan.leetcodescrapper.model.Problem;
import com.venkatakrishnan.leetcodescrapper.model.User;
import com.venkatakrishnan.leetcodescrapper.model.UserProblemMap;

@Service
public interface UserProblemMapService {

  public void saveUserProblemMap(UserProblemMap userProblemMap);
  
  public void saveSetOfUserProblemMap(Set<UserProblemMap> userProblemMap);
  
  public Set<UserProblemMap> getUserProblemMapByUser(User user);
  
  public Set<UserProblemMap> getUserProblemMapByProblem(Problem problem);
    
}
