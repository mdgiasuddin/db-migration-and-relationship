package com.example.flywaydb.repository;

import com.example.flywaydb.model.entity.Instructor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    @EntityGraph(attributePaths = {"courses", "courses.department"})
    Optional<Instructor> findOneById(Long id);
}
