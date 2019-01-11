package com.venkatakrishnan.leetcodescrapper.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.venkatakrishnan.leetcodescrapper.model.Problem;

@Service
public interface ProblemService {

  public void saveProblem(Problem Problem);
  
  public void saveProblems(Set<Problem> Problem);
  
  public Problem getProblem(int ProblemId);
    
}
