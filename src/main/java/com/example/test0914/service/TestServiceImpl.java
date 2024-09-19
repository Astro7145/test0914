package com.example.test0914.service;

import com.example.test0914.dto.TestDto;
import com.example.test0914.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository demoRepository;

    @Override
    public List<TestDto> objects() {
        return demoRepository.findAll().stream()
                .map(TestDto::of)
                .collect(Collectors.toList());
    }
}
