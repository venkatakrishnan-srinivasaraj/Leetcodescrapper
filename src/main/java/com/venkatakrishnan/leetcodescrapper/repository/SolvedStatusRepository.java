package com.venkatakrishnan.leetcodescrapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venkatakrishnan.leetcodescrapper.model.SolvedStatus;


@Repository
public interface SolvedStatusRepository extends JpaRepository<SolvedStatus, Long> {
  public SolvedStatus getSolvedStatusBysolvedStatus(String solvedStatus);
}
