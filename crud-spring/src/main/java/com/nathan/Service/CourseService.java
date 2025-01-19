package com.nathan.Service;

import java.util.List;
import java.util.stream.Collectors;

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

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

/*
 * Obs: Uso de assinatura de métodos fornecidos pela interface JpaRepository é possível
 * devido ao paradigma de Progrmação Orientada a Aspectos
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

    //método implementado automaticamente pelo Spring Data JPA
    public CoursePageDTO findAll(@PositiveOrZero int pageNumber, @Positive @Max(100) int pageSize) {
        Page<Course> pageCourse = courseRepository.findAll(PageRequest.of(pageNumber, pageSize));
        List<CourseDTO> list = pageCourse.getContent().stream().map(courseMapper::toDTO).toList();

        return new CoursePageDTO(list, pageCourse.getTotalElements(), pageCourse.getTotalPages());
    }

    //método implementado automaticamente pelo Spring Data JPA
    public CourseDTO findById(@NotNull @Positive Long id) {  //retorno: objeto do tipo Optional<Course>
        return courseRepository.findById(id)
                .map(courseMapper::toDTO)
                .orElseThrow(() -> new RecordNotFoundException(id));  //se o Optional estiver vazio, uma exceção personalizada é lançada
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
