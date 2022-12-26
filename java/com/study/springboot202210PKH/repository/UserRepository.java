package com.study.springboot202210PKH.repository;

import com.study.springboot202210PKH.web.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    public int saveUser(UserDto userDto);
    public UserDto findUserByUserId(int id);
    public UserDto findUserByUsername(String username);
}
