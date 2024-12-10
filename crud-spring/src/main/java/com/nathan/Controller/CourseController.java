package com.nathan.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nathan.Model.Course;
import com.nathan.Repository.CourseRepository;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    
    private final CourseRepository courseRepository;

    //OBS: essa forma de DI é uma boa prática uma vez que courseRepository passa ser um atributo obrigatório da classe,
    //pois o funcionamento do controller em si só fará sentido com a ligação ao repositório  
    
    //DI (Dependency Injection) via construtor 
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public List<Course> list(){
        return courseRepository.findAll();
    }
}
