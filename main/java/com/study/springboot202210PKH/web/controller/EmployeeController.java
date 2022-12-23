package com.study.springboot202210PKH.web.controller;

import com.study.springboot202210PKH.service.EmployeeService;
import com.study.springboot202210PKH.web.dto.CMRespDto;
import com.study.springboot202210PKH.web.dto.EmpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/emp")
    public ResponseEntity<?> addEmployee(@RequestBody  EmpDto empDto) {
        return ResponseEntity.created(null).body(new CMRespDto<>("직원등록완료", employeeService.addEmployee(empDto)));
    }
    /*
    <내가 만든것>
     @PostMapping("/test")
     public ResponseEntity<?> addEmployee(@RequestBody  EmpDto empDto) {
         return ResponseEntity.ok().body(empDto);
     }
    */
}
