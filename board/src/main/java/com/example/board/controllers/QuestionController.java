package com.example.board.controllers;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.board.domains.Question;
import com.example.board.dtos.AnswerDto;
import com.example.board.dtos.QuestionDto;
import com.example.board.interfaces.QuestionInterface;
import com.example.board.services.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;



@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
  private final QuestionInterface questionInterface;
  private final QuestionService questionService;

  @GetMapping("/list")
  public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
      Page<Question> paging = this.questionService.getList(page);
      model.addAttribute("paging", paging);
      return "question_list";
  }
  
  @GetMapping("/detail/{id}")
  public String detail(Model model, @PathVariable("id") Integer id, AnswerDto answerDto) {
      Question question = this.questionService.getQuestion(id);
      model.addAttribute("question", question);
      return "question_detail";
  }

  @GetMapping("/create")
  public String questionCreate(QuestionDto questionDto) { 
      return "question_form";
  }

  @PostMapping("/create")
  public String questionCreate(@Valid QuestionDto questionDto, BindingResult bindingResult) {
      if(bindingResult.hasErrors()){
        return "question_form ";
      }
      this.questionService.create(questionDto.getSubject(), questionDto.getContent());
      return "redirect:/question/list";
  }
  
  
  
}
