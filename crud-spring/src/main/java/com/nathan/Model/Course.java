package com.nathan.Model;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity  //entidade correspondente à uma tabela no BD
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //identificadores numéricos gerados automaticamente no BD
    @JsonProperty("_id")
    private Long id;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String name;
    
    @NotNull
    @Length(min = 10)
    @Pattern(regexp = "Back-end | Front-end")
    @Column(length = 10, nullable = false)
    private String category;

}
