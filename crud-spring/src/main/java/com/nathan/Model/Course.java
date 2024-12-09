package com.nathan.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity  //entidade correspondente à uma tabela no BD
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //identificadores numéricos gerados automaticamente no BD
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;
    
    @Column(length = 10, nullable = false)
    private String category;

}
