package com.study.springboot202210PKH.web.controller;


import com.study.springboot202210PKH.service.OptionService;
import com.study.springboot202210PKH.web.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/option")
public class optionController {

    @Autowired
    private OptionService  optionService;

    @PostMapping("/category")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto){
        return ResponseEntity
                .created(URI.create("/api/option/category" + optionService.addCategory(categoryDto)))
                .body(categoryDto);
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getCategories(){
        return ResponseEntity.ok(optionService.getCategories());
    }

    //수정하기
    @PutMapping("/category/{categoryId}")
    public ResponseEntity<?> modifyCategory(@PathVariable int categoryId, @RequestBody CategoryDto categoryDto){
        optionService.modifyCategory(categoryId, categoryDto);
        return ResponseEntity.ok(true);
    }
}
