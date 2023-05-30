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
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public Student createNewStudent(StudentRequest request) {
        Student student = new Student();

        student.setIdKey(UUID.randomUUID());
        student.setRollNumber(request.getRollNumber());
        student.setName(request.getName());

        return studentRepository.save(student);
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
                                .idKey(s.getIdKey())
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

    public StudentResponse getStudentById(Long id, UUID idKey) {
        Student student = studentRepository.findOneById(id)
                .orElseThrow(() -> new BusinessException("No student found..."));

        if (!student.getIdKey().equals(idKey)) {
            throw new BusinessException("You are not permitted to view this student");
        }

        return StudentResponse
                .builder()
                .id(student.getId())
                .idKey(student.getIdKey())
                .rollNumber(student.getRollNumber())
                .name(student.getName())
                .courses(
                        student.getRegisteredCourses()
                                .stream()
                                .map(
                                        c -> CourseResponse
                                                .builder()
                                                .id(c.getId())
                                                .name(c.getName())
                                                .build()
                                ).toList()
                )
                .build();
    }
}
