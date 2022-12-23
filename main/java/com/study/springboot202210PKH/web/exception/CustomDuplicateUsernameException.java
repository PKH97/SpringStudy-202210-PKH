package com.study.springboot202210PKH.web.exception;

import lombok.Getter;

import java.util.Map;

public class CustomDuplicateUsernameException extends RuntimeException {

    @Getter // -> 있어야 json 에서 정보를 가져올 수 있음
    private Map<String, String> errorMap;

    public CustomDuplicateUsernameException(String message, Map<String, String> errorMap) {
        super(message);
        this.errorMap = errorMap;
    }
}
