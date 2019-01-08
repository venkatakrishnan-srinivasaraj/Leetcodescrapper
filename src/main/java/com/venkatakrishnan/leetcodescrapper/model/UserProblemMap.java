package com.venkatakrishnan.leetcodescrapper.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user_problem", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "problem_id"}))
public class UserProblemMap {

  public UserProblemMap() {
  }

  public UserProblemMap(User user, Problem problem, SolvedStatus solvedStatus) {
    this.user = user;
    this.problem = problem;
    this.solvedStatus = solvedStatus;
  }


  @Id
  @GeneratedValue
  private int id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "problem_id")
  private Problem problem;

  @ManyToOne(cascade = CascadeType.ALL)
  private SolvedStatus solvedStatus;  

}
