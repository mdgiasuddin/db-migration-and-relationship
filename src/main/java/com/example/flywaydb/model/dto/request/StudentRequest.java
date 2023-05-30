package com.example.flywaydb.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank
    @Pattern(regexp = "[a-zA-Z0-9_ \\-.]{2,50}", message = "Name contains invalid characters...")
    private String name;
}
