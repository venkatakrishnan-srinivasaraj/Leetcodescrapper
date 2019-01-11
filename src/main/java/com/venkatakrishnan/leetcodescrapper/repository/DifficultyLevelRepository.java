package com.venkatakrishnan.leetcodescrapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venkatakrishnan.leetcodescrapper.model.DifficultyLevel;


@Repository
public interface DifficultyLevelRepository extends JpaRepository<DifficultyLevel, Long> {
  public DifficultyLevel getDifficultyLevelBydifficultyLevel(String difficultyLevel);
}
