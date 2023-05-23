package com.example.flywaydb.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CourseResponse {

    private Long id;
    private String name;
    private DepartmentResponse department;
    private InstructorResponse instructor;
}
