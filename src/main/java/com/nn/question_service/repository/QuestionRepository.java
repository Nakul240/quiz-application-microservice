package com.nn.question_service.repository;

import com.nn.question_service.data.models.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionRepository extends MongoRepository<Question,String> {
}
