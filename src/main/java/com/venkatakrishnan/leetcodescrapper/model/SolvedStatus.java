package com.venkatakrishnan.leetcodescrapper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "solved_status")
public class SolvedStatus {
  public SolvedStatus() {
  }

  public SolvedStatus(String solvedStatus) {
    this.solvedStatus = solvedStatus;
  }

  @Id
  @GeneratedValue
  private int id;

  @NotBlank
  @Column(unique = true)
  private String solvedStatus;

}
