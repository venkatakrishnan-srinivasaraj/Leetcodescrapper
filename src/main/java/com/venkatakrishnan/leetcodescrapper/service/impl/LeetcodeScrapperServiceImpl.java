package com.venkatakrishnan.leetcodescrapper.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.venkatakrishnan.leetcodescrapper.model.DifficultyLevel;
import com.venkatakrishnan.leetcodescrapper.model.Problem;
import com.venkatakrishnan.leetcodescrapper.model.SolvedStatus;
import com.venkatakrishnan.leetcodescrapper.model.User;
import com.venkatakrishnan.leetcodescrapper.model.UserProblemMap;
import com.venkatakrishnan.leetcodescrapper.service.DifficultyLevelService;
import com.venkatakrishnan.leetcodescrapper.service.LeetcodeScrapperService;
import com.venkatakrishnan.leetcodescrapper.service.ProblemService;
import com.venkatakrishnan.leetcodescrapper.service.SolvedStatusService;
import com.venkatakrishnan.leetcodescrapper.service.UserProblemMapService;

@Service
public class LeetcodeScrapperServiceImpl implements LeetcodeScrapperService {

  @Autowired
  @Qualifier("firefox")
  private WebDriver webDriver;

  @Autowired
  private ProblemService problemService;

  @Autowired
  UserProblemMapService userProblemMapService;

  @Autowired
  private SolvedStatusService solvedStatusService;

  @Autowired
  private DifficultyLevelService difficultyLevelService;

  @Override
  public Set<UserProblemMap> scrapUserSolvedStatus(User user) {
    webDriver.get("https://leetcode.com/accounts/login/");
    doDelay(2000);
    webDriver.findElement(By.xpath("//*[@id=\"username-input\"]")).sendKeys(user.getEmail());
    webDriver.findElement(By.xpath("//*[@id=\"password-input\"]")).sendKeys(user.getPassword());
    doDelay(2000);
    webDriver.findElement(By.xpath("//*[@id=\"sign-in-button\"]")).click();
    doDelay(2000);
    webDriver.get("https://leetcode.com/problemset/all/");
    doDelay(5000);
    webDriver.findElement(By.xpath(
        "/html/body/div[1]/div[3]/div[2]/div[2]/div[1]/div/div/div[2]/div[2]/div[2]/table/tbody[2]/tr/td/span/select"))
        .sendKeys("a");
    doDelay(3000);
    Set<UserProblemMap> userProblemMapUpdateSet = new HashSet<>();
    Set<UserProblemMap> userProblemMapExistingSet = userProblemMapService.getUserProblemMapByUser(user);
    Map<Integer, SolvedStatus> mapOfUserProblemMap = userProblemMapExistingSet.stream()
        .collect(Collectors.toMap(UserProblemMap::getProblemId, UserProblemMap::getSolvedStatus));
    List<WebElement> rows = webDriver
        .findElement(
            By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div[1]/div/div/div[2]/div[2]/div[2]/table/tbody[1]"))
        .findElements(By.tagName("tr"));
    for (WebElement eachRow : rows) {
      UserProblemMap userProblemMap = new UserProblemMap();
      userProblemMap.setUser(user);
      Problem problem = getProblemDetails(eachRow);
      userProblemMap.setProblem(problem);
      SolvedStatus solvedStatus = getSolvedStatus(eachRow);
      userProblemMap.setSolvedStatus(solvedStatus);
      if (mapOfUserProblemMap.get(problem.getId()) != solvedStatus) {
        userProblemMapUpdateSet.add(userProblemMap);
      }
    }
    return userProblemMapUpdateSet;
  }

  private SolvedStatus getSolvedStatus(WebElement eachRow) {
    List<WebElement> columns = eachRow.findElements(By.tagName("td"));
    String solvedStatusString = columns.get(0).getAttribute("value");
    if ("ac".equalsIgnoreCase(solvedStatusString)) {
      solvedStatusString = "Solved";
    } else if ("notac".equalsIgnoreCase(solvedStatusString)) {
      solvedStatusString = "Attempted";
    } else {
      solvedStatusString = "Todo";
    }
    SolvedStatus solvedStatus = solvedStatusService.getSolvedStatus(solvedStatusString);
    if (solvedStatus == null) {
      solvedStatus = new SolvedStatus(solvedStatusString);
      solvedStatusService.saveSolvedStatus(solvedStatus);
    }
    return solvedStatus;
  }

  private Problem getProblemDetails(WebElement eachRow) {
    List<WebElement> columns = eachRow.findElements(By.tagName("td"));
    int problemId = Integer.parseInt(columns.get(1).getText());
    Problem problem = null;
    problemService.getProblem(problemId);
    if (problem == null) {
      problem = extractProblemDetails(eachRow);
      problemService.saveProblem(problem);
    }
    return problem;
  }

  @Override
  public Set<Problem> scrapAllProblemDetails() {
    webDriver.get("https://leetcode.com/problemset/all/");
    doDelay(5000);
    webDriver.findElement(By.xpath(
        "/html/body/div[1]/div[3]/div[2]/div[2]/div[1]/div/div/div[2]/div[2]/div[2]/table/tbody[2]/tr/td/span/select"))
        .sendKeys("a");
    doDelay(3000);
    Set<Problem> problems = new HashSet<Problem>();
    List<WebElement> rows = webDriver
        .findElement(
            By.xpath("/html/body/div[1]/div[3]/div[2]/div[2]/div[1]/div/div/div[2]/div[2]/div[2]/table/tbody[1]"))
        .findElements(By.tagName("tr"));
    for (WebElement eachRow : rows) {
      Problem problem = extractProblemDetails(eachRow);
      problems.add(problem);
    }
    return problems;
  }

  private Problem extractProblemDetails(WebElement eachRow) {
    List<WebElement> columns = eachRow.findElements(By.tagName("td"));
    Problem problem = new Problem();
    int problemId = Integer.parseInt(columns.get(1).getText());
    problem.setId(problemId);
    String problemDescription = columns.get(2).getAttribute("value");
    String difficultyLevelString = columns.get(5).findElement(By.tagName("span")).getText();
    problem.setDescription(problemDescription);
    DifficultyLevel difficultyLevel = difficultyLevelService.getDifficultyLevel(difficultyLevelString);
    if (difficultyLevel == null) {
      difficultyLevel = new DifficultyLevel(difficultyLevelString);
      difficultyLevelService.saveDifficultyLevel(difficultyLevel);
    }
    problem.setDifficultyLevel(difficultyLevel);
    return problem;
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
