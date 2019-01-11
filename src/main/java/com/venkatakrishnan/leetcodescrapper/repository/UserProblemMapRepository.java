package com.venkatakrishnan.leetcodescrapper.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venkatakrishnan.leetcodescrapper.model.Problem;
import com.venkatakrishnan.leetcodescrapper.model.User;
import com.venkatakrishnan.leetcodescrapper.model.UserProblemMap;


@Repository
public interface UserProblemMapRepository extends JpaRepository<UserProblemMap, Long> {
  public Set<UserProblemMap> getUserProblemMapByUser(User user);
  public Set<UserProblemMap> getUserProblemMapByProblem(Problem problem);
}
