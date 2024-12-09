package com.nathan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nathan.Model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
