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
				System.out.println("SUCCESSFULLY DELETED COURSES.");

				Course c1 = new Course();
				c1.setName("Java COMPLETO + Orientação a Objetos");
				c1.setCategory(Category.BACK_END);

				Lesson lesson1_c1 = new Lesson();
				lesson1_c1.setName("Introdução a linguagem JAVA");
				lesson1_c1.setYoutubeUrl("https://youtube.com/aula1");
				lesson1_c1.setCourse(c1);
				
				Lesson lesson2_c1 = new Lesson();
				lesson2_c1.setName("Orientação a objetos");
				lesson2_c1.setYoutubeUrl("https://youtube.com/aula2");
				lesson2_c1.setCourse(c1);

				c1.getLessons().add(lesson1_c1);
				c1.getLessons().add(lesson2_c1);
				courseRepository.save(c1);

				Course c2 = new Course();
				c2.setName("Angular framework");
				c2.setCategory(Category.FRONT_END);

				Lesson lesson1_c2 = new Lesson();
				lesson1_c2.setName("Estrutura de diretórios com Angular");
				lesson1_c2.setYoutubeUrl("https://youtube.com/aula1");
				lesson1_c2.setCourse(c2);

				c2.getLessons().add(lesson1_c2);
				courseRepository.save(c2);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	}
}
