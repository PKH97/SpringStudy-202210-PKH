package com.study.springboot202210PKH.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.swing.plaf.synth.SynthToolTipUI;
import java.security.CodeSigner;

@Slf4j
@Aspect
@Component
public class ParamsAop {

    @Pointcut("@annotation(com.study.springboot202210PKH.aop.annotation.ParamsAspect)")
    private void annotationParams(){}

    @Around("annotationParams()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        CodeSignature codeSignature = (CodeSignature) proceedingJoinPoint.getSignature();
        String className = codeSignature.getDeclaringTypeName();
        String methodName = codeSignature.getName();

        String[] argNames = codeSignature.getParameterNames();
        Object[] args = proceedingJoinPoint.getArgs();

        for(int i = 0; i < argNames.length;  i++){
            log.info("Params >> {}.{}({}): {}", className, methodName, argNames[i], args[i]);
        }

        Object returnValue = proceedingJoinPoint.proceed();
        return returnValue;
    }

}

