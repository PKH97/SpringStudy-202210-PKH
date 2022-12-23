package com.study.springboot202210PKH.web.controller.advice;

import com.study.springboot202210PKH.web.dto.CMRespDto;
import com.study.springboot202210PKH.web.exception.CustomTestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice { // <- 예외를 걸러내서 답변

    @ExceptionHandler(CustomTestException.class)
    public ResponseEntity<?> testException(CustomTestException e) {
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), e.getErrorMap()));
    }

}
