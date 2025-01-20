package com.nathan.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import com.nathan.Exception.RecordNotFoundException;
import com.nathan.Model.Course;
import com.nathan.Repository.CourseRepository;
import com.nathan.dto.CourseDTO;
import com.nathan.dto.CoursePageDTO;
import com.nathan.dto.mapper.CourseMapper;
import com.nathan.enums.Status;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

/*
 * Using method signatures privided by the JpaRepository interface (without explicit declaration in CourseRepository)
 * is possible due to the Aspect Oriented Programming paradigm
 * 
 * findAll() e findById() are methods automatically generated at runtime by Spring Data JPA
 */

@Validated
@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }
    
    public CoursePageDTO findAll(@PositiveOrZero int pageNumber, @Positive @Max(100) int pageSize) {
        Page<Course> pageCourse = courseRepository.findAll(PageRequest.of(pageNumber, pageSize));
        List<CourseDTO> list = pageCourse.getContent().stream().map(courseMapper::toDTO).toList();

        return new CoursePageDTO(list, pageCourse.getTotalElements(), pageCourse.getTotalPages());
    }

    public CourseDTO findById(@NotNull @Positive Long id) {  // Return: object of type Optional<Course>
        return courseRepository.findById(id)
                .map(courseMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));  // If Optional is empty, a custom exception is thrown
    }

    public List<CourseDTO> findByName(@NotNull @NotBlank String name) {
        return courseRepository.findByName(name).stream().map(courseMapper::toDTO).toList();
    }

    public CoursePageDTO findByStatus(Status status, @PositiveOrZero int pageNumber, @Positive @Max(100) int pageSize) {
        Page<Course> pageCourse = courseRepository.findByStatus(status, PageRequest.of(pageNumber, pageSize));
        List<CourseDTO> list = pageCourse.getContent().stream().map(courseMapper::toDTO).toList();

        return new CoursePageDTO(list, pageCourse.getTotalElements(), pageCourse.getTotalPages());
    }

    public CourseDTO create(@Valid @NotNull CourseDTO course) {
        return courseMapper.toDTO(courseRepository.save(courseMapper.toEntity(course)));
    }

    public CourseDTO update(@NotNull @Positive Long id, @RequestBody @Valid @NotNull CourseDTO courseDTO) {
        return courseRepository.findById(id)
                .map(recordFound -> {
                    Course course = courseMapper.toEntity(courseDTO);
                    recordFound.setName(courseDTO.name());
                    recordFound.setCategory(this.courseMapper.convertCategoryValue(courseDTO.category()));
                    recordFound.getLessons().clear();
                    course.getLessons().forEach(lesson -> recordFound.getLessons().add(lesson));

                    return courseRepository.save(recordFound);
                })
                .map(courseMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@NotNull @Positive Long id) {
        courseRepository.delete(courseRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
