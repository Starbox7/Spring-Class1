package com.example.web.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.web.domains.User;
import com.example.web.services.UserService;





@Controller
public class UserController {
  private final UserService userService;
  //생성자
  public UserController (UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/login")
  public String login (){
    return "users/login";
  }

  @GetMapping("/join")
  public String join (){
    return "users/join";
  }

  @PostMapping("/register")
  public String register(UserForm userForm) {
      User user = new User();
      user.setId(userForm.getId());;
      user.setPassword(userForm.getPassword());
      
      userService.join(user);

      return "redirect:/login";
  }

  @GetMapping("/list")
  public String userList(Model model) {
    List<User> users = userService.findUsers();
      model.addAttribute("users", users);
      return "users/userList";
  }
  
  
}
