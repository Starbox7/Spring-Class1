package com.example.board.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.board.domains.DcuUser;
import com.example.board.interfaces.UserInterface;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
  private final UserInterface userInterface;

  private final PasswordEncoder passwordEncoder;

  public DcuUser create(String username, String email, String password){
    DcuUser user = new DcuUser();
    user.setUsername(username); 
    user.setEmail(email);

    //config replace
    // BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    user.setPassword(passwordEncoder.encode(password));

    this.userInterface.save(user);
    return user;
  }
}
