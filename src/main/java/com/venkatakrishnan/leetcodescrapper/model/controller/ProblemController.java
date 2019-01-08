package com.venkatakrishnan.leetcodescrapper.model.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.venkatakrishnan.leetcodescrapper.exception.ResourceNotFoundException;
import com.venkatakrishnan.leetcodescrapper.model.Problem;
import com.venkatakrishnan.leetcodescrapper.repository.ProblemRepository;

@RestController
public class ProblemController {

  @Autowired
  ProblemRepository problemRepository;

  @GetMapping("/problems")
  public Page<Problem> getAllproblems(Pageable pageable) {
    return problemRepository.findAll(pageable);
  }

  @PostMapping("/problems")
  public Problem createproblem(@Valid @RequestBody Problem problem) {
    return problemRepository.save(problem);
  }

  @PutMapping("/problems/{problemId}")
  public Problem updateproblem(@PathVariable Long problemId, @Valid @RequestBody Problem problemRequest) {
    return problemRepository.findById(problemId).map(problem -> {
      problem.setDescription(problemRequest.getDescription());
      problem.setDifficultyLevel(problemRequest.getDifficultyLevel());
      return problemRepository.save(problem);
    }).orElseThrow(() -> new ResourceNotFoundException("ProblemId " + problemId + " not found"));
  }


  @DeleteMapping("/problems/{problemId}")
  public ResponseEntity<?> deleteproblem(@PathVariable Long problemId) {
    return problemRepository.findById(problemId).map(problem -> {
      problemRepository.delete(problem);
      return ResponseEntity.ok().build();
    }).orElseThrow(() -> new ResourceNotFoundException("ProblemId " + problemId + " not found"));
  }


}
