package com.example.flywaydb.service;

import com.example.flywaydb.model.dto.request.StudentRequest;
import com.example.flywaydb.model.entity.Student;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ComponentScan
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class StudentServiceTest {

    @Autowired
    private Faker faker;

    @Autowired
    private StudentService studentService;

    @DisplayName("Should create new student")
    @ParameterizedTest
    @MethodSource("createStudentRequestArg")
    void test_saveStudent(StudentRequest request) {
        Student student = studentService.createNewStudent(request);

        assertEquals(student.getName(), request.getName());
        assertEquals(student.getRollNumber(), request.getRollNumber());
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
