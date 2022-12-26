package com.study.springboot202210PKH.locAndDi;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public void printStudentInfo(Student student) {
        System.out.println("학번: " + student.getStudentId());
        System.out.println("이름: " + student.getStudentName());
    }
}
