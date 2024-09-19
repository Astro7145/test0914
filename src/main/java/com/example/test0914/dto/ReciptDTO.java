package com.example.test0914.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReciptDTO {

    private Long id;
    
    private Date purchase_date;

    private int purchase_type;
    private int tax;

}
