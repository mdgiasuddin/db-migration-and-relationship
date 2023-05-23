package com.example.flywaydb.service;

import com.example.flywaydb.model.dto.request.InstructorRequest;
import com.example.flywaydb.model.dto.response.CourseResponse;
import com.example.flywaydb.model.dto.response.DepartmentResponse;
import com.example.flywaydb.model.entity.Instructor;
import com.example.flywaydb.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService {

    private final InstructorRepository instructorRepository;


    public String createNewInstructor(InstructorRequest request) {
        Instructor instructor = new Instructor();
        instructor.setName(request.getName());

        instructorRepository.save(instructor);

        return "Instructor created successfully...";
    }

    public List<CourseResponse> getAllCoursesOfInstructor(long id) {
        Instructor instructor = instructorRepository.findOneById(id)
                .orElseThrow(() -> new RuntimeException("No instructor found..."));

        return instructor.getCourses()
                .stream()
                .map(
                        c -> CourseResponse.builder()
                                .id(c.getId())
                                .name(c.getName())
                                .department(
                                        DepartmentResponse
                                                .builder()
                                                .id(c.getDepartment().getId())
                                                .name(c.getDepartment().getName())
                                                .build()
                                )
                                .build()
                ).toList();
    }
}
