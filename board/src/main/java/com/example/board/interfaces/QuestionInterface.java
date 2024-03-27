package com.example.board.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.board.domains.Question;


public interface QuestionInterface extends JpaRepository<Question, Integer> {
  Question findBySubject(String subject);

  Question findBySubjectAndContent(String subject, String content);

  List<Question> findBySubjectLike(String subject);
  
} 