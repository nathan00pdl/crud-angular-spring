package com.nathan.dto;

import com.nathan.enums.UserRole;

public record UserDTO(
    Long id,

    String login,

    UserRole role) {

}
