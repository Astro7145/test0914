package com.example.test0914.dto;

import com.example.test0914.entity.Test;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TestDto {

    private int id;
    private String name;


    @Builder
    public TestDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static TestDto of(Test test) {
        return TestDto.builder()
                .id(test.getId())
                .name(test.getName())
                .build();
    }
}
