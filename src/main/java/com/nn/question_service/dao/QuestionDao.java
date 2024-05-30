package com.nn.question_service.dao;

import com.nn.question_service.data.models.entity.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface QuestionDao {
    Question saveQuestion(Question question);

    List<Question> getAllQuestion();

    List<Question> generateQuizQuestions(String category, int noOfQuestions);
}
