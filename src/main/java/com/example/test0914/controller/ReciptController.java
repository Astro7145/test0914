package com.example.test0914.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test0914.dto.OrderDTO;
import com.example.test0914.dto.ReciptDTO;
import com.example.test0914.entity.Recipt;
import com.example.test0914.repository.ReciptRepository;
import com.example.test0914.service.ReciptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/recipt")
public class ReciptController {

    @Autowired
    private ReciptService reciptService;

    @Autowired
    private ReciptRepository reciptRepository;

    @PostMapping("/addRecipt")
    public OrderDTO addRecipt(@RequestBody OrderDTO order) {
        // OrderDTO result = reciptService.addRecipt(order);
        Recipt recipt = new Recipt();
        recipt.setId("RCT00000004");
        recipt.setPurchase_date("2024-09-19");
        recipt.setPurchase_type(1);
        recipt.setTax(10);
        reciptRepository.save(recipt);
        
        return order;
    }

    @GetMapping("/getRecipt")
    public String getRecipt(@RequestParam String recipt_id) {
        return new String();
    }
    
    
}
