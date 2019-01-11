package com.venkatakrishnan.leetcodescrapper.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.venkatakrishnan.leetcodescrapper.model.Problem;
import com.venkatakrishnan.leetcodescrapper.model.User;
import com.venkatakrishnan.leetcodescrapper.model.UserProblemMap;

@Service
public interface LeetcodeScrapperService {

  public Set<UserProblemMap> scrapUserSolvedStatus(User user);
  
  public Set<Problem> scrapAllProblemDetails();
  
}
