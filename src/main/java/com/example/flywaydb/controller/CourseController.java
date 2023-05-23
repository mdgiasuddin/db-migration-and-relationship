package com.example.flywaydb.controller;

import com.example.flywaydb.model.dto.request.CourseRequest;
import com.example.flywaydb.model.dto.response.CourseResponse;
import com.example.flywaydb.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/courses")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public String createNewCourse(@RequestBody @Validated CourseRequest request) {
        return courseService.createNewCourse(request);
    }

    @GetMapping
    public List<CourseResponse> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/filter")
    public List<CourseResponse> getFilteredCourses() {
        return courseService.getFilteredCourses();
    }
}
