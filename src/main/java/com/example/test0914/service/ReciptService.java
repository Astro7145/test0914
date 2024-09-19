package com.example.test0914.service;

import org.springframework.stereotype.Service;

import com.example.test0914.dto.OrderDTO;

@Service
public interface ReciptService {

    public OrderDTO addRecipt(OrderDTO order) throws Exception;

    public OrderDTO getRecipt(String recipt_id) throws Exception;
}
