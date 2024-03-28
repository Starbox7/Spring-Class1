package com.example.board.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.board.domains.DcuUser;

public interface UserInterface extends JpaRepository<DcuUser, Long> {
  
} 