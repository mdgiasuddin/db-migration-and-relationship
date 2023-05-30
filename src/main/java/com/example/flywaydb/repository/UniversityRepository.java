package com.example.flywaydb.repository;

import com.example.flywaydb.model.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UniversityRepository extends JpaRepository<University, UUID> {
}
