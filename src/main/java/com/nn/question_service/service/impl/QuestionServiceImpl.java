package com.nn.question_service.service.impl;

import com.nn.question_service.dao.QuestionDao;
import com.nn.question_service.data.models.dto.QuestionDto;
import com.nn.question_service.data.models.dto.ResponseStructure;
import com.nn.question_service.data.models.dto.Submission;
import com.nn.question_service.data.models.entity.Question;
import com.nn.question_service.service.QuestionService;
import com.nn.question_service.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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

    @Override
    public ResponseEntity<ResponseStructure<List<String>>> generateQuizQuestions(String category, int noOfQuestions) {
        List<Question> questions = questionDao.findByCategory(category);
        Collections.shuffle(questions);
        List<Question> quizQuestion = questions.subList(0,noOfQuestions);

        return ResponseUtil.getOk(quizQuestion.stream()
                .map(Question::get_id).collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<ResponseStructure<List<QuestionDto>>> getGeneratedQuestions(List<String> questionIds) {
      List<Question> questions = questionDao.getQuestionsByIds(questionIds);
      List<QuestionDto> questionDtos = new ArrayList<QuestionDto>();
      questions.forEach(q->questionDtos.add(mapQuestionToQuestionDto(q)));

        return ResponseUtil.getOk(questionDtos);
    }

    private QuestionDto mapQuestionToQuestionDto(Question q){
          return QuestionDto.builder()
                            ._id(q.get_id())
                            .question(q.getQuestion())
                            .option1(q.getOption1())
                            .option2(q.getOption2())
                            .option3(q.getOption3())
                            .option4(q.getOption4())
                            .build();
    }

    @Override
    public ResponseEntity<ResponseStructure<Integer>> getScore(List<Submission> submissions) {
        AtomicInteger count = new AtomicInteger();
        submissions.forEach(submission -> {
            if (submission.getChosenOption().equals(questionDao.findById(submission.getQuestionId()).getRightAnswer()))
                count.getAndIncrement();
        });


        return ResponseUtil.getOk(count.get());
    }

}
