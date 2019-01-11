package com.venkatakrishnan.leetcodescrapper.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkatakrishnan.leetcodescrapper.model.Problem;
import com.venkatakrishnan.leetcodescrapper.model.User;
import com.venkatakrishnan.leetcodescrapper.model.UserProblemMap;
import com.venkatakrishnan.leetcodescrapper.service.LeetcodeScrapperService;
import com.venkatakrishnan.leetcodescrapper.service.ProblemService;
import com.venkatakrishnan.leetcodescrapper.service.UserProblemMapService;
import com.venkatakrishnan.leetcodescrapper.service.UserService;

@RestController
public class ScrapLatestUpdateController {

  @Autowired
  UserService userService;
  
  @Autowired
  ProblemService problemService;
  
  @Autowired
  UserProblemMapService userProblemMapService;
  
  @Autowired
  private LeetcodeScrapperService leetcodeScrapperService;

  @RequestMapping(value = "/scrap/user/{userId}")
  public void scrapLatestDataForUserWithUserId(@PathVariable int userId) {
    User user = userService.getUser(userId);
    Set<UserProblemMap> setOfUpdatedStatuses = leetcodeScrapperService.scrapUserSolvedStatus(user);
    userProblemMapService.saveSetOfUserProblemMap(setOfUpdatedStatuses);
  }
  
  @RequestMapping(value = "/scrap/problems")
  public void scrapLatestProblems() {
    Set<Problem> latestProblems = leetcodeScrapperService.scrapAllProblemDetails();
    problemService.saveProblems(latestProblems);
  }

}
