package com.study.springboot202210PKH.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpDto {
    private int empId;
    private String empName;
    private int empAge;
    private String empPhone;
}
/*
<내가 만든것>
    public class EmpDto {
    private int empId;
    private String empName;
    private int empAge;
    private String empPhone;
}

*/
