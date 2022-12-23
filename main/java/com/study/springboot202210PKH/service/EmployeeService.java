package com.study.springboot202210PKH.service;

import com.study.springboot202210PKH.repository.EmployeeRepository;
import com.study.springboot202210PKH.web.dto.EmpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public int addEmployee(EmpDto empDto){
        return employeeRepository.saveEmployee(empDto) > 0 ? empDto.getEmpId() : 0;
    }

}
/*
<내가 만든것>
 @Autowired
 private EmployeeRepository employeeRepository;

 public int addEmployee(EmpDto empDto){
        int empId = 0;
        empId = employeeRepository.saveEmployee(empDto);
        return empId;
    }
 */
