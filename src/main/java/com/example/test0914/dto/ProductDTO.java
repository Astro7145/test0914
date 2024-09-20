package com.example.test0914.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private Long prod_serial;

    private String prod_name;

    private String purchase_date;

    private int prod_quantity;
    private int prod_price;
}
