package com.nathan.dto;

import com.nathan.enums.UserRole;

public record RegisterDTO(
    
    String login, 
    
    String password, 
    
    UserRole role) {
        
}
