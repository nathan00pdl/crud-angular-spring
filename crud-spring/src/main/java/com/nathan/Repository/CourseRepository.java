package com.nathan.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nathan.Model.Course;
import com.nathan.enums.Status;

/*
 * These methods are explicity declared as they are defined with custom parameters and return types compared to  
 * the same signatures provided by the JpaRepository interface.
 */

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByName(String name);

    Page<Course> findByStatus(Status status, PageRequest pageable);
}
