package com.nathan.dto;

import java.util.List;

public record CoursePageDTO(

        List<CourseDTO> courses,
        
        Long totalElements,
        
        int totalPages) {

}
