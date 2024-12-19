package com.nathan.dto.mapper;

import org.springframework.stereotype.Component;

import com.nathan.Model.Course;
import com.nathan.dto.CourseDTO;

//Temos uma lista de cursos e queremos retornar DTOs -> toDTO() é o método responsável por isso.

//Classe responsável pelo mapeamento de DTOs - Entidades.
@Component
public class CourseMapper {
    public CourseDTO toDTO(Course course) {
        if (course == null) {
            return null;
        }

        return new CourseDTO(course.getId(), course.getName(), course.getCategory());
    }

    public Course toEntity(CourseDTO courseDTO) {
        if (courseDTO == null) {
            return null;
        }

        Course course = new Course();
        if (courseDTO.id() != null) {
            course.setId(courseDTO.id());
        }
        
        course.setName(courseDTO.name());
        course.setCategory(courseDTO.category());

        return course;
    }
}
