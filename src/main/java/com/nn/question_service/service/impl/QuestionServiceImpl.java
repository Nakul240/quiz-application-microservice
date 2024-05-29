package com.nn.question_service.service.impl;

import com.nn.question_service.dao.QuestionDao;
import com.nn.question_service.data.models.dto.ResponseStructure;
import com.nn.question_service.data.models.entity.Question;
import com.nn.question_service.service.QuestionService;
import com.nn.question_service.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;

    @Override
    public ResponseEntity<ResponseStructure<Question>> saveQuestion(Question question) {
        return ResponseUtil.getCreated(questionDao.saveQuestion(question));
    }

    @Override
    public ResponseEntity<ResponseStructure<List<Question>>> getAllQuestion() {
        return ResponseUtil.getCreated(questionDao.getAllQuestion());
    }
}
