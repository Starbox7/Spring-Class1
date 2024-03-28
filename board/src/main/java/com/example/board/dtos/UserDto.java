package com.example.board.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

  @Size(min = 3, max = 25)
  @NotEmpty(message = "id is Empty")
  private String username;

  @NotEmpty(message = "password is Empty")
  private String password;

  @NotEmpty(message = "password confirm is Empty")
  private String confirm;

  @NotEmpty(message = "email is Empty")
  @Email
  private String email;


}
