package com.example.flywaydb.service;

import com.example.flywaydb.exceptions.BusinessException;
import com.example.flywaydb.model.dto.request.RegistrationRequest;
import com.example.flywaydb.model.dto.request.StudentRequest;
import com.example.flywaydb.model.dto.response.CourseResponse;
import com.example.flywaydb.model.dto.response.StudentResponse;
import com.example.flywaydb.model.entity.Course;
import com.example.flywaydb.model.entity.Student;
import com.example.flywaydb.repository.CourseRepository;
import com.example.flywaydb.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public String createNewStudent(StudentRequest request) {
        Student student = new Student();

        student.setRollNumber(request.getRollNumber());
        student.setName(request.getName());

        studentRepository.save(student);

        return "Student created successfully...";
    }

    public String registerStudent(RegistrationRequest request) {
        Student student = studentRepository.findStudentWithCoursesById(request.getStudentId())
                .orElseThrow(() -> new BusinessException("No student found..."));

        List<Course> courseList = courseRepository.findAllByIdIn(request.getCourseIdList());
        if (courseList.size() != request.getCourseIdList().size()) {
            throw new BusinessException("Some courses not found...");
        }

        student.getRegisteredCourses().addAll(courseList);
        studentRepository.save(student);

        return "Student registered with courses...";
    }

    public List<StudentResponse> getAllStudents() {
        List<Student> students = studentRepository.findAll();

        return students
                .stream()
                .map(
                        s -> StudentResponse
                                .builder()
                                .id(s.getId())
                                .rollNumber(s.getRollNumber())
                                .name(s.getName())
                                .courses(
                                        s.getRegisteredCourses()
                                                .stream()
                                                .map(
                                                        c -> CourseResponse
                                                                .builder()
                                                                .id(c.getId())
                                                                .name(c.getName())
                                                                .build()
                                                ).toList()
                                )
                                .build()
                )
                .toList();
    }
}
