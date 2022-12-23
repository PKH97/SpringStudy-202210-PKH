package com.study.springboot202210PKH.web.controller.account;

import com.study.springboot202210PKH.web.dto.CMRespDto;
import com.study.springboot202210PKH.web.exception.CustomDuplicateUsernameException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // -> 예외처리 가능하게 한다
public class AccountApiControllerAdvice {

    @ExceptionHandler(CustomDuplicateUsernameException.class)
    public ResponseEntity<?> duplicateError(CustomDuplicateUsernameException e){
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), e.getErrorMap()));
    } // -> 400오류 발생시의 응답

}
