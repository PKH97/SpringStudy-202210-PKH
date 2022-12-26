package com.study.springboot202210PKH.web.controller.account;

import com.study.springboot202210PKH.web.dto.CMRespDto;
import com.study.springboot202210PKH.web.exception.CustomDuplicateUsernameException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // -> 예외처리 가능하게 한다
public class AccountApiControllerAdvice {

    @ExceptionHandler(CustomDuplicateUsernameException.class)
    public ResponseEntity<?> duplicateError(CustomDuplicateUsernameException e){
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), e.getErrorMap()));
    } // -> 400오류 발생시의 응답

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> validationError(ConstraintViolationException e){
        Map<String, String> errorMap = new HashMap<>();
        System.out.println(e.getConstraintViolations());// -> set 형식이고 포이치 꺼낼 수 있음

        e.getConstraintViolations().forEach(error -> {
            String errorProperty = error.getPropertyPath().toString();
            errorProperty  = errorProperty.substring(errorProperty.lastIndexOf(".") + 1);
            errorMap.put(errorProperty, error.getMessage());
        });

        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), errorMap));
    }
}
