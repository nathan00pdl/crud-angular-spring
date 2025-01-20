package com.nathan.dto;

import java.util.List;
import java.util.Locale.Category;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nathan.enums.validation.ValueOfEnum;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/*
 * Record type
 * 
 * It is as special type of class that automaticaly manages the getters, equals(), hashCode() e toString()
 * They are designed precisely to represent immutable and simple objects like DTOs
 * Significant redution of lines of code  making the code clearer and cleaner
 * Each field in the record is automaticaly transformed into a private final attribute
 */

public record CourseDTO(
        @JsonProperty("_id") Long id,

        @NotBlank @NotNull @Length(min = 5, max = 100) String name,

        @NotNull @Length(max = 10) @ValueOfEnum(enumClass = Category.class) String category,

        @NotNull @NotEmpty @Valid List<LessonDTO> lessons) {
}
