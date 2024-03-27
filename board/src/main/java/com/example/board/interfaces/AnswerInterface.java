package com.example.board.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.board.domains.Answer;

public interface AnswerInterface extends JpaRepository<Answer, Integer> {

  
}