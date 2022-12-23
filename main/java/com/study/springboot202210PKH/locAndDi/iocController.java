package com.study.springboot202210PKH.locAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class iocController {

    @Autowired
    @Qualifier("usi3")
    // @Autowired(required = false) -> 이 주입은 필수가 아니다로 인식됨.(객체구현이 안됐을 때 사용)
    // @Qualifier 를 사용해서 원하는 @Component 지정할 수 있다.
    private UserService userService;

    @ResponseBody
    @GetMapping("/ioc")
    public String iocTest(){
        userService.createUser();
        userService.getUser();
        userService.updateUser();
        userService.deleteUser();
        return null;
    }
}
/*
IoC / DI
- 스프링이 알아서 객체를 생성한다.(@Component 을 기준으로.)
    @SpringBootApplication
    : @ComponentScan 이 들어있어 @Component 를 검색한다.
    이때 @Component  이 달린 클래스를 찾아내어 새로운 객체를 만들어준다.
    그리고 IoC 컨테이너에 넣는다.
    : 현재 하나의 @Component  만이 생성되었기 때문에 싱글톤의 형식을 따른다.

    @Autowired
    :  Ioc 컨테이너를 스캔한다. 그리고 해당 자리에 DI를 자동으로 주입해 준다.
    따라서
     @Autowired
    private UserService userService; 이 형태에서 이름을 바꿔도 알아서 찾아간다.
 */