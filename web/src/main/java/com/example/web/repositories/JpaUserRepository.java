package com.example.web.repositories;
import java.util.List;
import java.util.Optional;

import com.example.web.domains.User;

import jakarta.persistence.EntityManager;

// @Repository
public class JpaUserRepository implements UserRepository {

  private final EntityManager entityManager;

  public JpaUserRepository(EntityManager entityManager){
    this.entityManager = entityManager;
  };

  @Override
    public User add(User user) {
      entityManager.persist(user);
      return user;
    }

    // id 중복 확인, u : user 객체 -> 뭘 적든 user 객체로 접근함. 변경 가능함 
    @Override
    public Optional<User> findById(String id) {
      List<User> result = entityManager.createQuery("select u from User u where u.id = :id", User.class)
        .setParameter("id", id)
        .getResultList();

      return result.stream().findAny();
    }

    @Override
    public List<User> findAll() {
      return entityManager.createQuery("select u from User u", User.class).getResultList();
    }
}
