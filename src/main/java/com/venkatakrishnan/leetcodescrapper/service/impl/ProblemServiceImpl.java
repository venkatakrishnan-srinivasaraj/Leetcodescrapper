package com.venkatakrishnan.leetcodescrapper.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venkatakrishnan.leetcodescrapper.model.Problem;
import com.venkatakrishnan.leetcodescrapper.repository.ProblemRepository;
import com.venkatakrishnan.leetcodescrapper.service.ProblemService;

@Service
public class ProblemServiceImpl implements ProblemService {
  
  @Autowired
  ProblemRepository problemRepository;

  @Override
  public void saveProblem(Problem problem) {
    problemRepository.save(problem);
  }

  @Override
  public Problem getProblem(int problemId) {
    return problemRepository.getProblemById(problemId);
  }

  @Override
  public void saveProblems(Set<Problem> problems) {
    problemRepository.saveAll(problems);
  }

}
