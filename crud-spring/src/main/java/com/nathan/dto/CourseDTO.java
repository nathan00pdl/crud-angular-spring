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
 * Uso de Record
 * É um tipo especial de classe que gerencia de forma automática os getters, equals(), hashCode() e toString()
 * Foram projetados exatamente para representar objetos imutáveis e simples como os DTOs
 * Redução significativa de linhas de código, tornando o código mais claro e limpo 
 * Obs.: Cada campo do record é transformado automaticamente em um atributo private final
 * Atenção: Nomenclatura dos métodos gerados automaticamente: id(), name(), category() e lessons(). São todos métodos get!  
 */

public record CourseDTO(
        @JsonProperty("_id") Long id,

        @NotBlank @NotNull @Length(min = 5, max = 100) String name,

        @NotNull @Length(max = 10) @ValueOfEnum(enumClass = Category.class) String category,

        @NotNull @NotEmpty @Valid List<LessonDTO> lessons) {
}
