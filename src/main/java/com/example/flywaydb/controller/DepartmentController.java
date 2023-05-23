package com.example.flywaydb.controller;

import com.example.flywaydb.model.dto.request.DepartmentRequest;
import com.example.flywaydb.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/departments")
public class DepartmentController {

    private final DepartmentService departmentService;


    @PostMapping
    public String createNewDepartment(@RequestBody @Validated DepartmentRequest request) {
        return departmentService.createNewDepartment(request);
    }
}
