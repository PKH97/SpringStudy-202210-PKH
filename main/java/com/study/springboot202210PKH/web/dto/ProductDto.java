package com.study.springboot202210PKH.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto { // getter, setter 가 있어야 사용할 수 있다.
    private String productCode;
    private String productName;
    private String price;
    private String stock;
}
