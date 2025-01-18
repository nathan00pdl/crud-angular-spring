package com.nathan.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.nathan.Model.Course;
import com.nathan.Model.Lesson;
import com.nathan.dto.CourseDTO;
import com.nathan.dto.LessonDTO;
import com.nathan.enums.Category;

/*
 * Uso de um Mapper
 * Responsável por mapear as entidades com os respectivos DTOs
 * Mantém o desacoplamento entre as camadas da aplicação 
 * Garante que apenas dados relevantes sejam enviados para o front-end ou recebidos da aplicação cliente
 * Padrão Separation of Concerns
 * 
 * toDTO() -> Converte uma entidade persistida no banco de dados em um objeto DTO ao qual será utilizado no front-end
 * toEntity() -> Converte um objeto DTO em uma entidade para que possa ser validado e armazenados no banco de dados 
 */

@Component
public class CourseMapper {
    public CourseDTO toDTO(Course course) {
        if (course == null) {
            return null;
        }

        List<LessonDTO> lessons = course.getLessons()
                .stream()
                .map(lesson -> new LessonDTO(lesson.getId(), lesson.getName(), lesson.getYoutubeUrl()))
                .collect(Collectors.toList());

        return new CourseDTO(course.getId(), course.getName(), course.getCategory().getValue(), lessons);
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
        course.setCategory(convertCategoryValue(courseDTO.category()));

        List<Lesson> lessons = courseDTO.lessons().stream().map(lessonsDTO -> {
            var lesson = new Lesson();
            lesson.setId(lessonsDTO.id());
            lesson.setName(lessonsDTO.name());
            lesson.setYoutubeUrl(lessonsDTO.youtubeUtl());
            lesson.setCourse(course);
            return lesson;
        }).collect(Collectors.toList());
        course.setLessons(lessons);

        return course;
    }

    public Category convertCategoryValue(String value) {  
        if (value == null) {
            return null;
        }
        return switch (value) {
            case "Front-end" -> Category.FRONT_END;
            case "Back-end" -> Category.BACK_END;
            default -> throw new IllegalArgumentException("Categoria Inválida: " + value);
        };
    }
}
