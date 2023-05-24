package com.example.flywaydb.controller;

import com.example.flywaydb.model.dto.request.StudentRequest;
import com.example.flywaydb.model.entity.Student;
import com.example.flywaydb.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private StudentService studentService;

    @Autowired
    MockMvc mockMvc;

    @DisplayName("Should create loan with positive case")
    @ParameterizedTest
    @MethodSource("createStudentRequestArg")
    void test_saveStudent(StudentRequest request) throws Exception {
        when(studentService.createNewStudent(any(StudentRequest.class)))
                .thenReturn(Student.builder().build());

        String body = objectMapper.writeValueAsString(request);

        this.mockMvc.perform(post("/v1/students").contentType("application/json").content(body))
                .andExpect(status().isOk());
    }

    private Stream<Arguments> createStudentRequestArg() {
        return Stream.of(
                Arguments.of(createStudentRequest()),
                Arguments.of(createStudentRequest()),
                Arguments.of(createStudentRequest())
        );
    }

    private StudentRequest createStudentRequest() {
        return StudentRequest.builder()
                .name(faker.name().name())
                .rollNumber(faker.random().nextInt(121101, 923900))
                .build();
    }
}
