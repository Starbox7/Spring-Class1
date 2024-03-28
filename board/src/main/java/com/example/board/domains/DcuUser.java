package com.example.board.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class DcuUser {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; //index

  @Column(unique = true)
  private String username;
  
  @Column
  private String password;

  @Column(unique = true)
  private String email;
}
