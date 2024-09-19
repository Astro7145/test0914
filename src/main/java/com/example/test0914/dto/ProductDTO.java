package com.example.test0914.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductDTO {
    private String id;
    private String prod_serial;
    private String purchase_date;

    private int prod_quantity;
}
