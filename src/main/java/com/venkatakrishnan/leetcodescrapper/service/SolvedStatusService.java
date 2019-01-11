package com.venkatakrishnan.leetcodescrapper.service;

import org.springframework.stereotype.Service;

import com.venkatakrishnan.leetcodescrapper.model.SolvedStatus;

@Service
public interface SolvedStatusService {

  public void saveSolvedStatus(SolvedStatus solvedStatus);

  public SolvedStatus getSolvedStatus(String solvedStatus);

}
