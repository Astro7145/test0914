package com.example.test0914.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long id;
    private Long total_price;

    private String purchase_date;

    private boolean isSuccess;
    private boolean isDone;

    private int table_number;
    private int purchase_type;
    private int tax;

    private List<ProductDTO> products;
}
