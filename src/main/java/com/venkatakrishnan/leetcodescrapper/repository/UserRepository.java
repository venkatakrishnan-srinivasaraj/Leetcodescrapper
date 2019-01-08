package com.venkatakrishnan.leetcodescrapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venkatakrishnan.leetcodescrapper.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
