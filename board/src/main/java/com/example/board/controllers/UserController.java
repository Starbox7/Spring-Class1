package com.example.board.controllers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.board.dtos.UserDto;
import com.example.board.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;




@RequestMapping("/user")
@RequiredArgsConstructor
@Controller
public class UserController {
  private final UserService userService;

  @GetMapping("/signup")
  public String signup(UserDto userDto) {
      return "signup_form";
  }

  @PostMapping("/signup")
  public String signup(@Valid UserDto userDto, BindingResult bindingResult) {
      if(bindingResult.hasErrors()){
        return "signup_form";
      }

      if(!userDto.getPassword().equals(userDto.getConfirm())){
        bindingResult.rejectValue("confirm", "passwordIncorrect", "confirm is not valid");
        return "signup_form";
      }
      try {
        userService.create(userDto.getUsername(), userDto.getEmail(), userDto.getPassword());
        
      }catch(DataIntegrityViolationException e){
        e.printStackTrace();
        bindingResult.reject("signupFailed", "user has been already");
        return "signup_form";
      }catch(Exception e){
        e.printStackTrace();
        bindingResult.reject("signupFailed", e.getMessage());
        return "signup_form";
      }

      return "redirect:/";
  }
  
  @GetMapping("/login")
  public String login() {
      return "login_form";
  }
  
}
