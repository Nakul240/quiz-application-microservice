package com.nn.question_service.data.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequence_store")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sequence {

    @Id
    private String _id;
    private long count;
}
