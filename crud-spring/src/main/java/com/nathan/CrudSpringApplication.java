package com.nathan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nathan.Model.Course;
import com.nathan.Model.Lesson;
import com.nathan.Repository.CourseRepository;
import com.nathan.enums.Category;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository) {
		return args -> {
			courseRepository.deleteAll();
			
			Course c = new Course();
			
			c.setName("Angular com Spring");
			c.setCategory(Category.BACK_END);

			Lesson l = new Lesson();
			l.setName("Introdução");
			l.setYoutubeUrl("teste");
			l.setCourse(c);

			c.getLessons().add(l);

			courseRepository.save(c);
		};
	}

}
