package com.example.flywaydb.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

public record TestRequest(
        @NotEmpty
        Set<Long> idList,

        @NotBlank
        String name
) {
}
