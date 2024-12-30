package com.nathan.dto;

import java.util.List;

import com.nathan.Model.Course;

public record CoursePageDTO(List<Course> courses, Long totalElements, int totalPages) {

}
