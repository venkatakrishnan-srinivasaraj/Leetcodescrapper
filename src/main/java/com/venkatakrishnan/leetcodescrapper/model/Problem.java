package com.venkatakrishnan.leetcodescrapper.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "problem")
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
  @Size(max = 100)
  private String description;

  @ManyToOne(cascade = CascadeType.ALL)
  private DifficultyLevel difficultyLevel;

  @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<UserProblemMap> userServices = new HashSet<UserProblemMap>();

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public DifficultyLevel getDifficultyLevel() {
    return difficultyLevel;
  }

  public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
    this.difficultyLevel = difficultyLevel;
  }

  public Set<UserProblemMap> getUserServices() {
    return userServices;
  }

  public void setUserServices(Set<UserProblemMap> userServices) {
    this.userServices = userServices;
  }



}
