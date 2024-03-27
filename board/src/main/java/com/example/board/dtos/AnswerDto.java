package com.example.board.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerDto {
    @NotEmpty(message = "Content is Empty")
    private String content;
}