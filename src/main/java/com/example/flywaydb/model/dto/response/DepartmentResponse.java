package com.example.flywaydb.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DepartmentResponse {
    private Long id;
    private String name;
}
