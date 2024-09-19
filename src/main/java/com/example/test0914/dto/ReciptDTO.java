package com.example.test0914.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReciptDTO {

    private String id;
    private String purchase_date;
    private int purchase_type;

    private int tax;

}
