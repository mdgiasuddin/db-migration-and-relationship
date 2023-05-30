package com.example.flywaydb.controller;

import com.example.flywaydb.model.dto.request.RegistrationRequest;
import com.example.flywaydb.model.dto.request.StudentRequest;
import com.example.flywaydb.model.dto.response.StudentResponse;
import com.example.flywaydb.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public String createNewStudent(@RequestBody @Validated StudentRequest request) {
        studentService.createNewStudent(request);

        return "Student created successfully...";
    }

    @PostMapping("/register")
    public String registerStudent(@RequestBody @Validated RegistrationRequest request) {
        return studentService.registerStudent(request);
    }

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(
            @PathVariable("id") Long id,
            @RequestParam(name = "id_key", required = false) UUID idKey
    ) {
        return studentService.getStudentById(id, idKey);
    }

}
