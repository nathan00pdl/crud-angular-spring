package com.nathan.enums.converters;

import java.util.stream.Stream;

import com.nathan.enums.Category;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/*
 * AtributeConverter interface:  
 * 1) Save ENUM to database as a string. 
 * 2) Retrieve such string and convert to corresponding ENUM. 
 * 
 * By default JPA saves ENUMs as int type values and this can cause problems.
 */

@Converter(autoApply = true) 
public class CategoryConverter implements AttributeConverter<Category, String> {

    @Override
    public String convertToDatabaseColumn(Category category) {
        if (category == null) {
            return null;
        }
        return category.getValue();
    }

    @Override
    public Category convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(Category.values())
                .filter(c -> c.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    // Category.values() returns an array with the ENUM values: [Category.BACK_END, Category.FRONT_END]
}
