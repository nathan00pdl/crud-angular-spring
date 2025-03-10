package com.nathan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nathan.enums.UserRole;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDTO(
    
    @JsonProperty("_id") Long id,

    @NotBlank @NotNull @Size(min = 3, max = 20) String login,

    @NotBlank @NotNull UserRole role) {

}
