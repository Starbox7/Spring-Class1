package com.example.web.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.web.domains.User;
import com.example.web.repositories.MemoryUserRepository;

public class UserServiceTest {
  MemoryUserRepository userRepository;
  UserService userService;

  @BeforeEach
  public void beforeEach() {
    userRepository = new MemoryUserRepository();
    userService = new UserService(userRepository);
  } 

  @AfterEach
  public void afterEach () {
    userRepository.clearUser();
  }

  //user new join
  @Test
  void join(){
    //given
    User user = new User();
    user.setId("dcu");

    //when
    String id = userService.join(user);

    //then
    User findUser = userService.findOne(id).get();
    assertThat(user.getId()).isEqualTo(findUser.getId());
  }

  @Test
  public void duplicateUser() throws Exception {
    User user1 = new User();
    user1.setId("dcu");
    User user2 = new User();
    user2.setId("dcu");

    userService.join(user1);
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> userService.join(user2));
    
    assertThat(e.getMessage()).isEqualTo("Duplicate User");
  }
}