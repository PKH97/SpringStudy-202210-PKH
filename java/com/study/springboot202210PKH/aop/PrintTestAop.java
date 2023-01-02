package com.study.springboot202210PKH.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;

@Aspect
@Component
public class PrintTestAop {
    /*  해답  */
    @Pointcut("@annotation(com.study.springboot202210PKH.aop.annotation.PrintTestAspect)")
    private void annotationPrintCut(){}

    @Around("annotationPrintCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("PrintTestAop 실행!!");

        Object[] args = proceedingJoinPoint.getArgs();
        for(Object arg : args){
            System.out.println("매개변수 데이터 >>> " + arg);
        }

        Object returnValue = proceedingJoinPoint.proceed();

        System.out.println("메소드 결과 >>>" + returnValue);
        System.out.println("PrintTestAop 후처리 실행");

        return returnValue;
    }

}

//    내가 작성한 답지
//    @Pointcut("@annotation(com.study.springboot202210PKH.aop.annotation.PrintTestAspect)")
//    private void PrintTestPointcut(){}
//
//    @Around("PrintTestPointcut()")
//    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        Object[] args = proceedingJoinPoint.getArgs();
//
//        System.out.println("PrintTest AOP 작동됨!!!");
//
//        BeanPropertyBindingResult bindingResult = null;
//
//        for(Object arg : args){
//            if(arg.getClass() == BeanPropertyBindingResult.class){
//                bindingResult = (BeanPropertyBindingResult) arg;
//                break;
//            }
//        }
//        Object returnValue =  proceedingJoinPoint.proceed();
//        return returnValue;
//    }
/*
[기본 틀]

@Aspect
@Component
public class PrintTestAop {
    private void annotationPrintCut(){}

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {



        Object returnValue = proceedingJoinPoint.proceed();
        return returnValue;
    }

 */
