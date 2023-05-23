package com.example.flywaydb.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationRequest {
    private Long studentId;
    private List<Long> courseIdList;
}
