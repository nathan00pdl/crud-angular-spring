package com.nathan.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nathan.Model.Course;
import com.nathan.enums.Status;

/*
 * Obs: Esses métodos são declarados explicitamente, pois são definidos parâmetros e tipos de retornos personalizados em relação 
 * à disponibilidade das mesmas assinaturas por parte da interface JpaRepository
 */

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByName(String name);

    Page<Course> findByStatus(Status status, PageRequest pageable);
}
