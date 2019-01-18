package com.venkatakrishnan.leetcodescrapper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LeetcodescrapperApplication {

//  @Bean("firefox")
//  public WebDriver webDriverForFirefox() {
//    WebDriver firefoxWebDriver = new FirefoxDriver();
//    firefoxWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    return firefoxWebDriver;
//  }

  // @Bean("chrome")
  // public WebDriver webDriverForChrome() {
  // WebDriver chromeWebDriver = new ChromeDriver();
  // chromeWebDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  // return chromeWebDriver;
  // }

  public static void main(String[] args) {
    System.setProperty("webdriver.gecko.driver", "C:\\java_installations\\geckodriver.exe");
    System.setProperty("webdriver.chrome.driver", "C:\\java_installations\\chromedriver.exe");
    SpringApplication.run(LeetcodescrapperApplication.class, args);
  }

}

