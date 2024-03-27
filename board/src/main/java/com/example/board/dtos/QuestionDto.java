package com.example.board.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDto {
    @NotEmpty(message = "Title is Empty")
    @Size(max=200)
    private String subject;
    @NotEmpty(message = "Content is Empty")
    private String content;
}