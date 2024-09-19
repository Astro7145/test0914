package com.example.test0914.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderDTO {

    private String id;
    private String purchase_date;
    private boolean isSuccess;

    private int purchase_type;
    private int tax;

    private List<ProductDTO> products;
}
