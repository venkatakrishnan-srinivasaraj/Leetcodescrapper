package com.venkatakrishnan.leetcodescrapper.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_problem", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "problem_id"}))
@Getter
@Setter
@ToString
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

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "problem_id")
  private Problem problem;

  @ManyToOne
  private SolvedStatus solvedStatus;  
  
  public int getProblemId() {
    return problem.getId();
  }

}
