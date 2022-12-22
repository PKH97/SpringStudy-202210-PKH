package com.study.springboot202210PKH.web.controller;

import com.study.springboot202210PKH.web.dto.CMRespDto;
import com.study.springboot202210PKH.web.dto.UserDto;
import com.study.springboot202210PKH.web.exception.CustomTestException;
import com.sun.net.httpserver.Headers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestController1 {

    @GetMapping("/api/test/user-dto/str")
    public String getUerDtoStr() {
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        return userDto.toString();
    }

    @GetMapping("/api/test/user-dto/obj")
    public ResponseEntity<?> getUerDtoObj() {
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.set("UserDto", userDto.toString());
//        return new ResponseEntity<>(headers, HttpStatus.OK);
        return ResponseEntity.ok()
                    .headers(headers)
                    .body(userDto);
//        return ResponseEntity.ok().body(""); //<- 빌더 패턴 (직관성이 높다)
        // .ok()는 status 면서 body 를 포함한다. , 필요한것이 없는경우 .status() 를 사용
    }

    @GetMapping("/api/test/user-dto/cm")
    public ResponseEntity<?> getUserDto(){
        UserDto userDto = UserDto.builder()
                        .username("test")
                        .password("1234")
                        .build();
        return ResponseEntity.ok().body(new CMRespDto<>("test 유저 정보 응답", null));
    }

    @PostMapping("/api/test/user")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto){

        if(userDto.getUsername().isBlank()){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("username", "아이디를 입력하세요.");

            throw new CustomTestException("유효성 검사 실패", errorMap);
        }

        userDto.setUserId(200);
        return ResponseEntity.created(null)
                .body(new CMRespDto<>(userDto.getUserId() + "사용자 추가 성공!", userDto));
    }
}
