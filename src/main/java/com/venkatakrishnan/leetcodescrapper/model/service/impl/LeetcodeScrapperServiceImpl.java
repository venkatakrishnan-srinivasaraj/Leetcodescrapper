package com.venkatakrishnan.leetcodescrapper.model.service.impl;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.venkatakrishnan.leetcodescrapper.model.User;
import com.venkatakrishnan.leetcodescrapper.model.service.LeetcodeScrapperService;

@Service
public class LeetcodeScrapperServiceImpl implements LeetcodeScrapperService {

  @Autowired
  @Qualifier("firefox")
  private WebDriver webDriver;
  
  @Override
  public void scrapLatestData(User user) {
   
    
  }

}
