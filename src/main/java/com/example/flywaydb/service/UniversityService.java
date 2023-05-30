package com.example.flywaydb.service;

import com.example.flywaydb.model.dto.request.UniversityRequest;
import com.example.flywaydb.model.entity.University;
import com.example.flywaydb.repository.UniversityRepository;
import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UniversityService {

    private final UniversityRepository universityRepository;

    public University createNewUniversity(UniversityRequest request) {
        String ulid = UlidCreator.getUlid().toString();
        System.out.println("Ulid: " + ulid);

        University university = new University();
        university.setName(request.getName());
        
        return university;
//        return universityRepository.save(university);
    }
}
