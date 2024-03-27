package com.example.board;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.board.domains.Question;
import com.example.board.interfaces.QuestionInterface;

@SpringBootTest
class BoardApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private QuestionInterface questionInterface;

	@Test
	void testJpa() {
		// Question q1 = new Question();
		// q1.setSubject("question subject setter test1 한글 테스트");
		// q1.setContent("question content setter test1 한글 테스트");
		// q1.setCreateDate(LocalDateTime.now());
		// this.questionInterface.save(q1);

		// Question q2 = new Question();
		// q2.setSubject("question subject setter test2 한글 테스트");
		// q2.setContent("question content setter test2 한글 테스트");
		// q2.setCreateDate(LocalDateTime.now());
		// this.questionInterface.save(q2);

		for (int i = 0; i < 500; i++){
			Question q = new Question();
			q.setSubject("Test " + i);
			q.setContent("Test " + i);
			q.setCreateDate(LocalDateTime.now());
			this.questionInterface.save(q);
		}
	}

}
