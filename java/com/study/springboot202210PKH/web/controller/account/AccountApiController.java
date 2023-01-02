package com.study.springboot202210PKH.web.controller.account;

import com.study.springboot202210PKH.aop.annotation.ParamsAspect;
import com.study.springboot202210PKH.aop.annotation.PrintTestAspect;
import com.study.springboot202210PKH.aop.annotation.TimerAspect;
import com.study.springboot202210PKH.aop.annotation.ValidAspect;
import com.study.springboot202210PKH.service.UserService;
import com.study.springboot202210PKH.web.dto.CMRespDto;
import com.study.springboot202210PKH.web.dto.UserDto;
import com.study.springboot202210PKH.web.dto.UsernameDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;


@Slf4j
@RestController
@RequestMapping("/api/account")
public class AccountApiController {

//    Simple Log Fasade -> slf,
//    private static final Logger LOG = LoggerFactory.getLogger(AccountApiController.class); -> @Slf4j 로 대체. log 로 작성한다.

    @Autowired
    private UserService userService;

    @ParamsAspect
    @TimerAspect
    @PrintTestAspect
    @ValidAspect
    @GetMapping("/username")
    public ResponseEntity<?> duplicateUsername(@Valid UsernameDto usernameDto, BindingResult bindingResult) {
        log.info("로그 출력!! 데이터 : {}", usernameDto);

        userService.duplicateUsername(usernameDto.getUsername());
        return  ResponseEntity.ok().body(new CMRespDto<>("가입가능한 사용자이름", true));
    } //if를 빼서 하나의 기능만 하도록해 가시성을 높임

    @ParamsAspect
    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody @Valid UserDto userDto, BindingResult bindingResult){
        return ResponseEntity
                    .created(URI.create("/account/login"))
                    .body(new CMRespDto<>("회원가입 완료", null));
    }

}
