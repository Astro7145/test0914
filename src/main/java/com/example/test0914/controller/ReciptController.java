package com.example.test0914.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test0914.dto.OrderDTO;
import com.example.test0914.service.ReciptService;
import com.example.test0914.service.ReciptServiceImpl;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/recipt")
public class ReciptController {

    private ReciptService reciptService;

    public ReciptController(ReciptServiceImpl reciptService) {
        this.reciptService = reciptService;
    }

    @Transactional
    @PostMapping("/addRecipt")
    public OrderDTO addRecipt(@RequestBody OrderDTO order) throws Exception {
        OrderDTO result = reciptService.addRecipt(order);

        return result;
    }

    @Transactional
    @GetMapping("/getRecipt")
    public OrderDTO getRecipt(@RequestParam String recipt_id) throws Exception {
        OrderDTO result = reciptService.getRecipt(recipt_id);

        return result;
    }

    @Transactional
    @GetMapping("/getReciptList")
    public List<OrderDTO> getReciptList() throws Exception {
        List<OrderDTO> result = reciptService.getReciptList();

        return result;
    }
    
    @PutMapping("/setReciptDone/{recipt_id}")
    public boolean setReciptDone(@PathVariable Long recipt_id) throws Exception {
        boolean result = reciptService.setReciptDone(recipt_id);
        
        return result;
    }
    
    @PutMapping("/cancelRecipt/{recipt_id}")
    public boolean cancelRecipt(@PathVariable Long recipt_id) throws Exception {
        boolean result = reciptService.cancelRecipt(recipt_id);
        
        return result;
    }
    
    
    
    
}
