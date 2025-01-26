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
			try {
				courseRepository.deleteAll();
				System.out.println("Cursos deletados com sucesso.");

				for (int i = 1; i <= 10; i++) {
					Course c = new Course();
					c.setName("Curso " + i);
					c.setCategory(i % 2 == 0 ? Category.BACK_END : Category.FRONT_END);
	
					Lesson l1 = new Lesson();
					l1.setName("Aula introdutória: " + i);
					l1.setYoutubeUrl("https://youtube.com/" + i);
					l1.setCourse(c);
					c.getLessons().add(l1);

					courseRepository.save(c);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		};
	}

}
