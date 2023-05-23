package com.example.flywaydb.service;

import com.example.flywaydb.exceptions.BusinessException;
import com.example.flywaydb.model.dto.request.CourseRequest;
import com.example.flywaydb.model.dto.response.CourseResponse;
import com.example.flywaydb.model.dto.response.DepartmentResponse;
import com.example.flywaydb.model.dto.response.InstructorResponse;
import com.example.flywaydb.model.entity.Course;
import com.example.flywaydb.model.entity.Department;
import com.example.flywaydb.model.entity.Instructor;
import com.example.flywaydb.repository.CourseRepository;
import com.example.flywaydb.repository.DepartmentRepository;
import com.example.flywaydb.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final DepartmentRepository departmentRepository;
    private final InstructorRepository instructorRepository;


    public String createNewCourse(CourseRequest request) {

        Department department = departmentRepository.findDepartmentById(request.getDepartmentId())
                .orElseThrow(() -> new BusinessException("No department found..."));

        Instructor instructor = instructorRepository.findById(request.getInstructorId())
                .orElseThrow(() -> new BusinessException("No instructor found..."));

        Course course = new Course();
        course.setName(request.getName());
        course.setDepartment(department);
        course.setInstructor(instructor);

        courseRepository.save(course);

        return "Course created successfully...";
    }

    public List<CourseResponse> getAllCourses() {

        List<Course> courses = courseRepository.findAll();

        return courses
                .stream()
                .map(
                        c -> CourseResponse
                                .builder()
                                .id(c.getId())
                                .name(c.getName())
                                .department(
                                        DepartmentResponse
                                                .builder()
                                                .id(c.getDepartment().getId())
                                                .name(c.getDepartment().getName())
                                                .build()
                                )
                                .instructor(
                                        InstructorResponse
                                                .builder()
                                                .id(c.getInstructor().getId())
                                                .name(c.getInstructor().getName())
                                                .build()
                                )
                                .build()
                ).toList();
    }

    public List<CourseResponse> getFilteredCourses() {
        List<Course> courses = courseRepository.filterCourses("CSE", "Md. Giash Uddin");

        return courses
                .stream()
                .map(
                        c -> CourseResponse
                                .builder()
                                .id(c.getId())
                                .name(c.getName())
                                .department(
                                        DepartmentResponse
                                                .builder()
                                                .id(c.getDepartment().getId())
                                                .name(c.getDepartment().getName())
                                                .build()
                                )
                                .instructor(
                                        InstructorResponse
                                                .builder()
                                                .id(c.getInstructor().getId())
                                                .name(c.getInstructor().getName())
                                                .build()
                                )
                                .build()
                ).toList();
    }
}
