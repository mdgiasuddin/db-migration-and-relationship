package com.example.flywaydb.repository;


import com.example.flywaydb.model.entity.Course;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @EntityGraph(attributePaths = {"department", "instructor"})
    List<Course> findAll();

    List<Course> findAllByIdIn(Set<Long> courseIdList);

    @EntityGraph(attributePaths = {"department", "instructor"})
    @Query("select c from Course c where c.department.name = :department_name" +
            " and c.instructor.name = :instructor_name")
    List<Course> filterCourses(
            @Param("department_name") String departmentName,
            @Param("instructor_name") String instructorName
    );

}
