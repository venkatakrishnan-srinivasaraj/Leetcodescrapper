package com.venkatakrishnan.leetcodescrapper.service;

import org.springframework.stereotype.Service;

import com.venkatakrishnan.leetcodescrapper.model.DifficultyLevel;

@Service
public interface DifficultyLevelService {

  public void saveDifficultyLevel(DifficultyLevel difficultyLevel);

  public DifficultyLevel getDifficultyLevel(String difficultyLevel);

}
