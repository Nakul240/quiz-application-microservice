package com.nn.question_service.service;

import com.nn.question_service.data.models.dto.QuestionDto;
import com.nn.question_service.data.models.dto.ResponseStructure;
import com.nn.question_service.data.models.dto.Submission;
import com.nn.question_service.data.models.entity.Question;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuestionService {
    ResponseEntity<ResponseStructure<Question>> saveQuestion(Question question);

    ResponseEntity<ResponseStructure<List<Question>>> getAllQuestion();

    ResponseEntity<ResponseStructure<List<String>>> generateQuizQuestions(String category, int noOfQuestions);

    ResponseEntity<ResponseStructure<List<QuestionDto>>> getGeneratedQuestions(List<String> questionIds);

    ResponseEntity<ResponseStructure<Integer>> getScore(List<Submission> submissions);
}
