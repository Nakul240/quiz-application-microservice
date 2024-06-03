package com.nn.question_service.dao;

import com.nn.question_service.data.models.entity.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface QuestionDao {
    Question saveQuestion(Question question);

    Question findById(String id);

    List<Question> getAllQuestion();

    List<Question> findByCategory(String category);

    List<Question> getQuestionsByIds(List<String> questionIds);
}