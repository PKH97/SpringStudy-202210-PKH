package com.study.springboot202210PKH.web.controller;

import com.study.springboot202210PKH.service.UserService;
import com.study.springboot202210PKH.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URL;

@RestController
/* @Controller 는 html 을 응답할 때 사용.(@ResponseBody 를 달아주면 데이터 응답 가능)
@RestController 는 @ResponseBody 를 사용하고 있는 것과 동일 (html 응답 x)*/
@RequestMapping("/api/db/test")
public class DBTestController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
        // @RequestBody 는 UserDto 의 제이슨의 형태로 받을 수 있다
        System.out.println(userDto);
        int userId = userService.addUser(userDto);
//        return new ResponseEntity<>("응답할 데이터", HttpStatus.CREATED);
                // -> 제네릭 형식 ("응답할 데이터"들의 형태가 다양하기 떄문에 와일드카드를 사용한다)
                // 원래는 이와 같은 형태로 만든다.
                // HttpStatus.BAD_REQUEST 를 사용하면 400을 지정할 수 있다
        return ResponseEntity.created(URI.create("/api/db/test/user/" + userId)).body(userDto); //->빌더 형식
    }

    @GetMapping("/user/{userId}") // {} 안의 변수명은  @PathVariable 의 매개변수 명과 동일해야 한다.
    public ResponseEntity<?> getUser(@PathVariable int userId){
        UserDto userDto = userService.getUser(userId);
        return ResponseEntity.ok().body(userDto);

    }

}
