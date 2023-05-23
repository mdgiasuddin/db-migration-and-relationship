package com.example.flywaydb.repository;

import com.example.flywaydb.model.entity.Student;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @EntityGraph(attributePaths = {"registeredCourses"})
    List<Student> findAll();

    @EntityGraph(attributePaths = {"registeredCourses"})
    Optional<Student> findStudentWithCoursesById(Long id);
}
