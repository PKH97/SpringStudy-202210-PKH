package com.study.springboot202210PKH.locAndDi;

import java.nio.file.attribute.UserPrincipalLookupService;

public class Main {
    private final UserService userService;

    public Main(UserService userService){ // 현재 UserServiceImpl은 Main 클래스의 의존성이 높다
        this.userService = userService;       // 그래서 매개변수로 UserService를 받는다.
    }

    public void run(){
        userService.createUser();
        userService.getUser();
        userService.updateUser();
        userService.deleteUser();
    }

    public static  void main(String[] args){
        UserService userService = UserServiceImpl.getInstance();
        // main에 UserService의 의존성을 외부에서 주입했다. = DI
        // spring에서는 IoC로 바뀐다.
        Main main = new Main(userService);
        main.run();
    }

}
