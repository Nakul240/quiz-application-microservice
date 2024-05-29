package com.nn.question_service.data.models.entity;

import com.nn.question_service.data.models.enums.DifficultyLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "questions")
public class Question {

    @Transient
    public static final String SequenceId = "question_Sequence";

    @Id
    private String _id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String category;
    private DifficultyLevel difficultyLevel;
}
