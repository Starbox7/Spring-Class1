package com.example.board.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.board.domains.Answer;
import com.example.board.domains.Question;
import com.example.board.interfaces.AnswerInterface;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {
  private final AnswerInterface answerInterface;

   public void create(Question question, String content){
    Answer a = new Answer();
    a.setContent(content);  
    a.setCreateDate(LocalDateTime.now());
    a.setQuestion(question);
    this.answerInterface.save(a);
  }
}
