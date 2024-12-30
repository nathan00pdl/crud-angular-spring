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
			for (int i = 0; i <= 20; i++) {

				courseRepository.deleteAll();

				Course c = new Course();

				c.setName("Angular com Spring");
				c.setCategory(Category.BACK_END);

				Lesson l1 = new Lesson();
				l1.setName("Introdução");
				l1.setYoutubeUrl("1234567891");
				l1.setCourse(c);
				c.getLessons().add(l1);

				Lesson l2 = new Lesson();
				l2.setName("Introdução");
				l2.setYoutubeUrl("12345678910");
				l2.setCourse(c);
				c.getLessons().add(l2);

				courseRepository.save(c);
			}
		};
	}

}
