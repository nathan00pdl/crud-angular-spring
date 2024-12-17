package com.nathan.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nathan.Model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Override
    @Query("SELECT c FROM Course c WHERE c.status = 'Ativo'")
    List<Course> findAll();
}
