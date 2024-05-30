package com.nn.question_service.repository;

import com.nn.question_service.data.models.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

import java.util.List;

public interface QuestionRepository extends MongoRepository<Question,String> {

    List<Question> findByCategory(String category);

    @Query(value = "{$match: {category: ?0}}, {$sample: {size: ?1}}")
    List<Question> generateQuizQuestions(String category, int noOfQuestions);
}