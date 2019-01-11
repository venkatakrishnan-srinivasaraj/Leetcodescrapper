package com.venkatakrishnan.leetcodescrapper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venkatakrishnan.leetcodescrapper.model.DifficultyLevel;
import com.venkatakrishnan.leetcodescrapper.repository.DifficultyLevelRepository;
import com.venkatakrishnan.leetcodescrapper.service.DifficultyLevelService;

@Service
public class DifficultyLevelServiceImpl implements DifficultyLevelService{
  
  @Autowired
  DifficultyLevelRepository difficultyLevelRepository;

  @Override
  public void saveDifficultyLevel(DifficultyLevel difficultyLevel) {
    difficultyLevelRepository.save(difficultyLevel);
  }

  @Override
  public DifficultyLevel getDifficultyLevel(String difficultyLevel) {
    return difficultyLevelRepository.getDifficultyLevelBydifficultyLevel(difficultyLevel);
  }

}
