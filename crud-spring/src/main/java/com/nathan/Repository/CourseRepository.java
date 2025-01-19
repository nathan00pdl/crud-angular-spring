package com.nathan.Repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nathan.Model.Course;
import com.nathan.enums.Status;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Page<Course> findByStatus(Pageable pageable ,Status status);
    List<Course> findByName(String name);
}
