package com.example.flywaydb.controller;

import com.example.flywaydb.model.dto.request.RegistrationRequest;
import com.example.flywaydb.model.dto.request.StudentRequest;
import com.example.flywaydb.model.dto.response.StudentResponse;
import com.example.flywaydb.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public String createNewStudent(@RequestBody @Validated StudentRequest request) {
        return studentService.createNewStudent(request);
    }

    @PostMapping("/register")
    public String registerStudent(@RequestBody @Validated RegistrationRequest request) {
        return studentService.registerStudent(request);
    }

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }

}
