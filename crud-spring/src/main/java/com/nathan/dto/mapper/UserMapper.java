package com.nathan.dto.mapper;

import org.springframework.stereotype.Component;

import com.nathan.Model.User;
import com.nathan.dto.UserDTO;
import com.nathan.enums.UserRole;

@Component
public class UserMapper {
    public UserDTO toDTO(User user) {
        if (user == null) return null;

        return new UserDTO(user.getId(), user.getLogin(), user.getRole());
    }

    public User toEntity(UserDTO userDTO) {
        if (userDTO == null) return null;

        UserRole role = userDTO.role();

        User user = new User();
        user.setId(userDTO.id());
        user.setLogin(userDTO.login());
        user.setRole(role);

        return user;
    }
}
