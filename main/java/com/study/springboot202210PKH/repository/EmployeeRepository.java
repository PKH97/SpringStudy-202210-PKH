package com.study.springboot202210PKH.repository;

import com.study.springboot202210PKH.web.dto.EmpDto;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface EmployeeRepository {
    public int saveEmployee(EmpDto empDto);
}
/*
<내가 만든것>
@Mapper
public interface EmployeeRepository {
    public int saveEmployee(EmpDto empDto);
}
 */