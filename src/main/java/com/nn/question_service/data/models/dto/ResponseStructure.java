package com.nn.question_service.data.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseStructure <T>{
    private int statusCode;
    private HttpStatus message;
    private T data;
}
