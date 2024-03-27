package com.example.board.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.board.domains.Question;
import com.example.board.exception.DataNotFoundException;
import com.example.board.interfaces.QuestionInterface;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {
  private final QuestionInterface questionInterface;

  public List<Question> getList() {
    return this.questionInterface.findAll();
  }

  public Question getQuestion(Integer id){
    Optional<Question> question = this.questionInterface.findById(id);
    if(question.isPresent()){
      return question.get();
    }else{
      throw new DataNotFoundException("question not found");
    }
  }

  public void create(String subject, String content){
    Question q = new Question();
    q.setSubject(subject);
    q.setContent(content);  
    q.setCreateDate(LocalDateTime.now());
    this.questionInterface.save(q);
  }

  public Page<Question> getList(int page){
    List<Sort.Order> sorts = new ArrayList<>();
    sorts.add(Sort.Order.desc("createDate"));
    Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
    return this.questionInterface.findAll(pageable);
  }
}
