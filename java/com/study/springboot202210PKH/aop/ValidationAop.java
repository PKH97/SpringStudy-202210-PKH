package com.study.springboot202210PKH.aop;

import com.study.springboot202210PKH.web.exception.CustomValidException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;

import java.beans.BeanProperty;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class ValidationAop {

    @Pointcut("execution(* com.study.springboot202210PKH.web.controller.account.AccountApiController.*(..))")
    //AccountApiController 안의 모든 메소드 사용지정
    private void executionPointCut(){}

    @Pointcut("@annotation(com.study.springboot202210PKH.aop.annotation.ValidAspect)")
    private void annotationPointCut(){}

    @Around("annotationPointCut()")
    //@Around: 실행되기 전과 후, 둘다 의미.
    // @Around("executionPointCut() || 포인트컷2") -> 비교할 수도 있다.
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        for(Object arg : args) {
            System.out.println(arg);
        }

        System.out.println("AOP 작동함!!!");

        BeanPropertyBindingResult bindingResult = null;

        for(Object arg : args){
            if(arg.getClass() == BeanPropertyBindingResult.class){
                bindingResult = (BeanPropertyBindingResult) arg;
                break;
            }
        }

        if(bindingResult != null){
            if(bindingResult.hasErrors()){
                Map<String, String> errorMap = new HashMap<>();
                bindingResult.getFieldErrors().forEach(error -> { //리스트를 반환해줌, 포이치사용가능
                    errorMap.put(error.getField(), error.getDefaultMessage());
                });

                throw new CustomValidException(errorMap);
            }
        }

        //메소드 호출 전 처리
        Object returnValue =  proceedingJoinPoint.proceed();
        //메소드 호출 후 처리

        return returnValue;
//        return  proceedingJoinPoint.proceed();
        //proceedingJoinPoint.proceed(); : @Around 의 기준점. Object 로 리턴한다.
    }
}
