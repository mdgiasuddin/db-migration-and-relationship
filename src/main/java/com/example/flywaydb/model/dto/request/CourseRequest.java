package com.example.flywaydb.model.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseRequest {

    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9_]{5,25}")
    private String username;

    @Min(100)
    @Max(100000000)
    private Double amount;

    private String name;
    private Long departmentId;
    private Long instructorId;
}
