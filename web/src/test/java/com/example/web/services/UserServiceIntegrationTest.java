package com.example.web.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.web.domains.User;
import com.example.web.repositories.UserRepository;

@SpringBootTest //Test단에서 DB 접근
@Transactional //실제로 DB에 넣지 않게 처리함
public class UserServiceIntegrationTest {

  @Autowired UserService userService;
  @Autowired UserRepository userRepository;

  @Test
  public void join() {
    //given
    User user = new User();
    user.setId("dcu");
    user.setPassword("1234");

    //when
    String id = userService.join(user);

    //then
    User findUser = userService.findOne(id).get();
    assertThat(user.getId()).isEqualTo(findUser.getId());
  }

    @Test
    public void duplicateUser() throws Exception {
      User user1 = new User();
      user1.setId("dcu1");
      user1.setPassword("1234");
      User user2 = new User();
      user2.setId("dcu1");
      user2.setPassword("1234");

      userService.join(user1);
      IllegalStateException e = assertThrows(IllegalStateException.class, () -> userService.join(user2));
      
      assertThat(e.getMessage()).isEqualTo("Duplicate User");
  }
}

