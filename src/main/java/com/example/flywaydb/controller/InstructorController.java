package com.example.flywaydb.controller;

import com.example.flywaydb.model.dto.request.InstructorRequest;
import com.example.flywaydb.model.dto.response.CourseResponse;
import com.example.flywaydb.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @PostMapping
    public String createNewInstructor(@RequestBody @Validated InstructorRequest request) {
        return instructorService.createNewInstructor(request);
    }

    @GetMapping("/{id}/courses")
    public List<CourseResponse> getAllCoursesOfInstructor(@PathVariable long id) {
        return instructorService.getAllCoursesOfInstructor(id);
    }
}
