package com.nathan.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record LessonDTO(

        Long id,

        @NotNull @NotEmpty @Length(min = 5, max = 100) String name,

        @NotNull @NotEmpty @Length(min = 10, max = 30) String youtubeUrl) {

}
