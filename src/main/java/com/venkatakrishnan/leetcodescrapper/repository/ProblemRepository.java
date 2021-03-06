package com.venkatakrishnan.leetcodescrapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venkatakrishnan.leetcodescrapper.model.Problem;


@Repository
public interface ProblemRepository extends JpaRepository<Problem, Long> {
  public Problem getProblemById(int id);

}
