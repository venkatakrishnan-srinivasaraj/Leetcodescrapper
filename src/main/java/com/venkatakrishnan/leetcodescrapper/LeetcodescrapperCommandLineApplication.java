//package com.venkatakrishnan.leetcodescrapper;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import com.venkatakrishnan.leetcodescrapper.model.DifficultyLevel;
//import com.venkatakrishnan.leetcodescrapper.model.Problem;
//import com.venkatakrishnan.leetcodescrapper.model.SolvedStatus;
//import com.venkatakrishnan.leetcodescrapper.model.User;
//import com.venkatakrishnan.leetcodescrapper.model.UserProblemMap;
//import com.venkatakrishnan.leetcodescrapper.repository.ProblemRepository;
//import com.venkatakrishnan.leetcodescrapper.repository.UserRepository;
//
//@SpringBootApplication
//public class LeetcodescrapperCommandLineApplication implements CommandLineRunner {
//
//  @Autowired
//  private UserRepository userRepository;
//
//  @Autowired
//  private ProblemRepository problemRepository;
//
//  public static void main(String[] args) {
//    SpringApplication.run(LeetcodescrapperCommandLineApplication.class, args);
//  }
//
//  @Override
//  public void run(String... args) throws Exception {
//    // Cleanup the tables
//    userRepository.deleteAllInBatch();
//    problemRepository.deleteAllInBatch();
//
//
//    User user = new User("venkat", "venkatakrishnan111@gmail.com", "Java@2019");
//
//    Problem problem1 = new Problem(1, "description 1", new DifficultyLevel("EASY"));
//    Problem problem2 = new Problem(2, "description 2", new DifficultyLevel("MEDIUM"));
//
//    UserProblemMap userProblemMapping1 = new UserProblemMap(user, problem1, new SolvedStatus("SOLVED"));
//    UserProblemMap userProblemMapping2 = new UserProblemMap(user, problem2, new SolvedStatus("ATTEMPTED"));
//
//    user.getUserServices().add(userProblemMapping1);
//    user.getUserServices().add(userProblemMapping2);
//
////
////    problem1.getUserServices().add(userProblemMapping1);
////    problem2.getUserServices().add(userProblemMapping2);
//
//    userRepository.save(user);
////    problemRepository.save(problem1);
////    problemRepository.save(problem2);
//
//    // =======================================
//
//  }
//}
//
//
