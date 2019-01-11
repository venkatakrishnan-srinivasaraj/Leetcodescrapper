package com.venkatakrishnan.leetcodescrapper.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
public class User{
  
  public User() {
    
  }
  
  public User(String username,String email,String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotNull
  @Column(unique = true)
  private String username;

  @NotNull
  private String email;

  @NotNull
  private String password;

  @OneToMany(mappedBy = "user")
  private Set<UserProblemMap> userServices = new HashSet<UserProblemMap>();


}
