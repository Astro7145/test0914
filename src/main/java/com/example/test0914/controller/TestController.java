package com.example.test0914.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.test0914.dto.TestDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/list")
    public List<String> list() {
        return List.of("apple", "banana", "peach");
    }

    @GetMapping("/objList")
    public List<TestDto> objList() {
        return List.of(new TestDto(1, "apple"), new TestDto(2, "banana"), new TestDto(3, "peach"));
    }
    
    

}
