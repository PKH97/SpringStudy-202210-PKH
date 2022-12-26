package com.study.springboot202210PKH.web.controller;

import com.study.springboot202210PKH.web.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductTestController {

    @GetMapping("/product/addition")
    public String loadAddition(){
        return "product/product_add";
    }

//    방법 1) -> HttpServletRequest
//    @PostMapping("/api/product")
//    public String registerProduct(HttpServletRequest request){
//        System.out.println(request.getParameter("price"));
//        return "product/product_view";
//    }

//    방법 2) -> @RequestParam
//    @PostMapping("/api/product")
//    public String registerProduct(@RequestParam String productCode,
//                                                @RequestParam String productName,
//                                                @RequestParam("price") int price,
//                                                @RequestParam int stock){
//        System.out.println(productName);
//        // 같은 String 타입이기 때문에 생략이 가능하다. but 가시적 판별을 위해 붙여줘야 한다.
//        System.out.println(price);
//        return "product/product_view";
//    }

//    방법 3) -> ProductDto
    @PostMapping("/api/product")
    public String registerProduct(Model model, ProductDto productDto){
        model.addAttribute("productDto", productDto);
        System.out.println(productDto);
        return "product/product_view";
    }

    @GetMapping("/product/addition2")
    public String loadAddition2(){
        return "product/product_add2";
    }

//    @ResponseBody // -> 있으면 view 응답, 없으면 string 응답
//    @PostMapping("/api/product/2")
//    public String registerProduct(ProductDto productDto){
//        System.out.println(productDto);
//        return productDto.toString();
//    }

    @ResponseBody // -> JSON
    @PostMapping("/api/product/2")
    public String registerProduct(@RequestBody ProductDto productDto){
        System.out.println(productDto);
        return "텍스트 데이터 응답";
    }
}
