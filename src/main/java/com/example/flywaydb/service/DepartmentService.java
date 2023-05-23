package com.example.flywaydb.service;

import com.example.flywaydb.exceptions.BusinessException;
import com.example.flywaydb.model.dto.request.DepartmentRequest;
import com.example.flywaydb.model.entity.Department;
import com.example.flywaydb.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public String createNewDepartment(DepartmentRequest request) {
        if (departmentRepository.existsByName(request.getName())) {
            throw new BusinessException("Department already exist...");
        }

        Department department = new Department();
        department.setName(request.getName());
        departmentRepository.save(department);

        return "Department created successfully...";
    }
}
