package com.venkatakrishnan.leetcodescrapper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venkatakrishnan.leetcodescrapper.model.SolvedStatus;
import com.venkatakrishnan.leetcodescrapper.repository.SolvedStatusRepository;
import com.venkatakrishnan.leetcodescrapper.service.SolvedStatusService;

@Service
public class SolvedStatusServiceImpl implements SolvedStatusService{
  
  @Autowired
  SolvedStatusRepository solvedStatusRepository;

  @Override
  public void saveSolvedStatus(SolvedStatus solvedStatus) {
    solvedStatusRepository.save(solvedStatus);
  }

  @Override
  public SolvedStatus getSolvedStatus(String solvedStatus) {
    return solvedStatusRepository.getSolvedStatusBysolvedStatus(solvedStatus);
  }

}
