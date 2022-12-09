package com.study.springboot202210PKH.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controller1 {

//    @RequestMapping(value = "/page1", method = RequestMethod.GET)
    @GetMapping("/page1")
    public ModelAndView page1(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("page1");
        mav.addObject("key", "value");
        return mav;
    }
    // 위와 아래는 같다.
//    public  String page1(){
//        return "page1";
//    }

    @GetMapping("page2")
    public  String page2(){
        return "page2";
    }


}
