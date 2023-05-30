package com.example.flywaydb.controller;

import com.example.flywaydb.model.dto.request.UniversityRequest;
import com.example.flywaydb.model.entity.University;
import com.example.flywaydb.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/university")
public class UniversityController {

    private final UniversityService universityService;

    @PostMapping
    public String createNewUniversity(@RequestBody @Validated UniversityRequest request) {
        University university = universityService.createNewUniversity(request);
        return "University created successfully with id: " + university.getId();
    }
}
