package com.example.web.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.web.repositories.JpaUserRepository;
import com.example.web.repositories.UserRepository;
import com.example.web.services.UserService;

import jakarta.persistence.EntityManager;



@Configuration
public class Configure {
  private final EntityManager entityManager;

  public Configure(EntityManager entityManager){
    this.entityManager = entityManager;
  }

  @Bean
  public UserService userService(){
    return new UserService(userRepository());
  }

  @Bean
  public UserRepository userRepository() {
    return new JpaUserRepository(entityManager);
  }
}
