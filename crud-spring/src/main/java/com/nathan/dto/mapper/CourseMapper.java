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
 * Using a Mapper:
 * 
 * Responsible for mapping entities with their respective DTOs.
 * Maintains decoupling between application layers.
 * Ensures the only relevant data is sent to the fron-end or recieved from the client application.
 * Standard: Separation of Concerns.
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
            lesson.setYoutubeUrl(lessonsDTO.youtubeUrl());
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
