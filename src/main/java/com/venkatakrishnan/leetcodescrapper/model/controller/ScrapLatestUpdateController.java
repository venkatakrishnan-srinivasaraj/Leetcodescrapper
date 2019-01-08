package com.venkatakrishnan.leetcodescrapper.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkatakrishnan.leetcodescrapper.model.User;
import com.venkatakrishnan.leetcodescrapper.model.service.LeetcodeScrapperService;
import com.venkatakrishnan.leetcodescrapper.model.service.UserService;

@RestController
public class ScrapLatestUpdateController {

  @Autowired
  UserService userService;
  
  @Autowired
  private LeetcodeScrapperService leetcodeScrapperService;

  @RequestMapping(value = "/scrapforuser/{userId}")
  public void scrapLatestDataForUserWithUserId(@PathVariable int userId) {
    User user = userService.getUser(userId);
    leetcodeScrapperService.scrapLatestData(user);
  }

}
