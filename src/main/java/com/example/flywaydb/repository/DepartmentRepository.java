package com.example.flywaydb.repository;

import com.example.flywaydb.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findDepartmentById(Long id);

    boolean existsByName(String name);
}
