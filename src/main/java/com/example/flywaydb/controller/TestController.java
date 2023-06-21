package com.example.flywaydb.controller;

import com.example.flywaydb.model.dto.request.TestRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @PostMapping
    public String test(@RequestBody @Validated TestRequest request) {

        System.out.println(request);
        return "Done!";
    }
}
