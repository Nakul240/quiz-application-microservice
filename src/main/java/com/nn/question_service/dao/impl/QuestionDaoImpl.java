package com.nn.question_service.dao.impl;

import com.nn.question_service.dao.QuestionDao;
import com.nn.question_service.data.models.entity.Question;
import com.nn.question_service.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDaoImpl implements QuestionDao {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> generateQuizQuestions(String category, int noOfQuestions) {
        return questionRepository.generateQuizQuestions(category,noOfQuestions);
    }
}
