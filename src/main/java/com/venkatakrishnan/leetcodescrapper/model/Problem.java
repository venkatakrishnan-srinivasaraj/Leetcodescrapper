package com.venkatakrishnan.leetcodescrapper.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "problem")
@Getter
@Setter
@ToString
public class Problem {

  public Problem() {
  }

  public Problem(int id, String description, DifficultyLevel difficultyLevel) {
    this.id = id;
    this.description = description;
    this.difficultyLevel = difficultyLevel;
  }

  @Id
  private int id;

  @NotNull
  private String description;

  @ManyToOne
  private DifficultyLevel difficultyLevel;

}
