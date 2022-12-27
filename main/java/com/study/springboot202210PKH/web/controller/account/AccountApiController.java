package com.study.springboot202210PKH.web.controller.account;

import com.study.springboot202210PKH.service.UserService;
import com.study.springboot202210PKH.web.dto.CMRespDto;
import com.study.springboot202210PKH.web.dto.UserDto;
import com.study.springboot202210PKH.web.dto.UsernameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    @Autowired
    private UserService userService;

    @GetMapping("/username")
    public ResponseEntity<?> duplicateUsername(@Valid UsernameDto usernameDto, BindingResult bindingResult) {
        userService.duplicateUsername(usernameDto.getUsername());
        return  ResponseEntity.ok().body(new CMRespDto<>("가입가능한 사용자이름", true));
    } //if를 빼서 하나의 기능만 하도록해 가시성을 높임

    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody @Valid UserDto userDto, BindingResult bindingResult){
        return ResponseEntity
                    .created(URI.create("/account/login"))
                    .body(new CMRespDto<>("회원가입 완료", null));
    }

}
