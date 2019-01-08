package com.venkatakrishnan.leetcodescrapper.model.service.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
    webDriver.get("https://leetcode.com/accounts/login/");
    doDelay(2000);
    webDriver.findElement(By.xpath("//*[@id=\"username-input\"]")).sendKeys(user.getEmail());
    webDriver.findElement(By.xpath("//*[@id=\"password-input\"]")).sendKeys(user.getPassword());
    doDelay(2000);
    webDriver.findElement(By.xpath("//*[@id=\"sign-in-button\"]")).click();
    doDelay(2000);
    webDriver.get("https://leetcode.com/problemset/all/");
    doDelay(3000);
    webDriver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div[1]/div/div/div[2]/div[2]/div[2]/table/tbody[2]/tr/td/span/select")).sendKeys("a");
    doDelay(3000);
    System.out.println("yeah");
  }
  
  private void doDelay(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
