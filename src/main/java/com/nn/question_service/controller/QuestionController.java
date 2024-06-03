package com.nn.question_service.controller;

import com.nn.question_service.data.models.dto.QuestionDto;
import com.nn.question_service.data.models.dto.ResponseStructure;
import com.nn.question_service.data.models.dto.Submission;
import com.nn.question_service.data.models.entity.Question;
import com.nn.question_service.service.QuestionService;
import com.nn.question_service.util.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private SequenceGenerator sequenceGenerator;

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<ResponseStructure<Question>> saveQuestion(@RequestBody Question question) {
        question.set_id(sequenceGenerator.getSequence(Question.SequenceId));
        return questionService.saveQuestion(question);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<Question>>> getAllQuestion() {
        return questionService.getAllQuestion();
    }

    @GetMapping("/generate")
    public ResponseEntity<ResponseStructure<List<String>>> generateQuizQuestions(@RequestParam String category,@RequestParam int noOfQuestions) {
        return questionService.generateQuizQuestions(category,noOfQuestions);
    }

    @PostMapping("/getQuestions")
    public ResponseEntity<ResponseStructure<List<QuestionDto>>> getGeneratedQuestions(@RequestBody List<String> questionIds){
        return questionService.getGeneratedQuestions(questionIds);
    }

    @PostMapping("/getScore")
    public ResponseEntity<ResponseStructure<Integer>> getScore(@RequestBody List<Submission> submissions){
        return questionService.getScore(submissions);
    }
}
