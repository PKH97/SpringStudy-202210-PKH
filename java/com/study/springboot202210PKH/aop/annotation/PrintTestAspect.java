package com.study.springboot202210PKH.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // -> RUNTIME 시점에 사용/시작된다
@Target({ElementType.TYPE, ElementType.METHOD})
//    -> ElementType: 어디에 사용할지 지정
public @interface PrintTestAspect {
}
