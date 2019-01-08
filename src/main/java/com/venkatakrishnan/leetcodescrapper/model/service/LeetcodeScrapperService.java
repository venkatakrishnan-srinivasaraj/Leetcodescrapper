package com.venkatakrishnan.leetcodescrapper.model.service;

import org.springframework.stereotype.Service;

import com.venkatakrishnan.leetcodescrapper.model.User;

@Service
public interface LeetcodeScrapperService {

  public void scrapLatestData(User user);
  
}
