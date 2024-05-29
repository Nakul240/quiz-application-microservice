package com.nn.question_service.util;

import com.nn.question_service.data.models.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil<T> {

    private static <T> ResponseStructure<T> initResponseStructure(){
        return new ResponseStructure<T>();
    }

    public static <T> ResponseEntity<ResponseStructure<T>>  getCreated(T t){
        ResponseStructure<T> structure = initResponseStructure();
        structure.setStatusCode(HttpStatus.CREATED.value());
        structure.setMessage(HttpStatus.CREATED);
        structure.setData(t);

        return ResponseEntity.status(structure.getStatusCode()).body(structure);
    }

    public static <T> ResponseEntity<ResponseStructure<T>>  getOk(T t){
        ResponseStructure<T> structure = initResponseStructure();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage(HttpStatus.OK);
        structure.setData(t);

        return ResponseEntity.status(structure.getStatusCode()).body(structure);
    }
}
