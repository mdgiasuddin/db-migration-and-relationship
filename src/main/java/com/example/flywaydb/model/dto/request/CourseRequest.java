package com.example.flywaydb.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseRequest {

    private String name;
    private Long departmentId;
    private Long instructorId;
}
