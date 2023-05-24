package com.example.flywaydb.model.dto.request;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentRequest {

    private Integer rollNumber;
    private String name;
}
