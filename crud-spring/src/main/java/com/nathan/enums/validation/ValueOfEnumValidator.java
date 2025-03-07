package com.nathan.enums.validation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/*
 * Note:
 * 
 * This class implements the validation logic for the @ValueOfEnum annotation. 
 */

public class ValueOfEnumValidator implements ConstraintValidator<ValueOfEnum, CharSequence> {
    private List<String> acceptedValues;

    @Override
    public void initialize(ValueOfEnum annotation) {
        acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
            .flatMap(enumConstant -> Stream.of(enumConstant.name(), ((com.nathan.enums.Category) enumConstant).getValue()))
            .map(String::toLowerCase)
            .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) { // "context" is only declared to follow the method signature provided by the interface
        return value == null || acceptedValues.contains(value.toString().toLowerCase());
    }
}
