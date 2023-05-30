package com.example.flywaydb.repository;

import com.example.flywaydb.model.entity.Student;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @EntityGraph(attributePaths = {"registeredCourses"})
    List<Student> findAll();

    @EntityGraph(attributePaths = {"registeredCourses"})
    Optional<Student> findOneById(Long id);

    @EntityGraph(attributePaths = {"registeredCourses"})
    @Query("select s from Student s where s.name = :name")
    List<Student> findStudentsByName(@Param("name") String name);

    @EntityGraph(attributePaths = {"registeredCourses"})
    Optional<Student> findStudentWithCoursesById(Long id);
}
