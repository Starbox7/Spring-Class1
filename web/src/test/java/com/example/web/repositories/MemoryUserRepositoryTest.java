package com.example.web.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.example.web.domains.User;;

public class MemoryUserRepositoryTest {
  MemoryUserRepository repository = new MemoryUserRepository();

  @AfterEach
  public void afterEach() {
    repository.clearUser();
  }

  @Test
  public void add() {
    // given
    User user = new User();
    user.setId("dcu");

    //when
    repository.add(user);

    //then
    User result = repository.findById(user.getId()).get();
    assertThat(result).isEqualTo(user);
  }

  @Test
  public void findById(){
    // given
    User user1 = new User();
    user1.setId("user1");
    repository.add(user1);
    User user2 = new User();
    user2.setId("user2");
    repository.add(user2);

    //when
    User result = repository.findById("user1").get();

    //then
    assertThat(result).isEqualTo(user1);
  }

  @Test
  public void findAll(){
    //given
    User user1 = new User();
    user1.setId("user1");
    repository.add(user1);
    User user2 = new User();
    user2.setId("user2");
    repository.add(user2);

    //when
    List<User> result = repository.findAll();

    //then
    assertThat(result.size()).isEqualTo(2);
  }
}
