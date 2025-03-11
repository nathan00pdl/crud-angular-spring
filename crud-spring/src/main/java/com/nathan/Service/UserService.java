package com.nathan.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nathan.Repository.UserRepository;
import com.nathan.dto.UserDTO;
import com.nathan.dto.mapper.UserMapper;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(user -> userMapper.toDTO(user)).toList();
    }
}
