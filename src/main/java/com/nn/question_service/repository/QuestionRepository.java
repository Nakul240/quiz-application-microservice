package com.nn.question_service.repository;

import com.nn.question_service.data.models.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionRepository extends MongoRepository<Question,String> {

    List<Question> findByCategory(String category);

    List<Question> findBy_idIn(List<String> ids);

}