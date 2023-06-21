package com.example.flywaydb.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record StudentRequest(

        @NotNull
        Integer rollNumber,
        @NotBlank
        @Size(min = 2, max = 20)
        String name

) {

}
