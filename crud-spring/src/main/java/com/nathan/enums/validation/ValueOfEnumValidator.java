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
        .map(Enum::toString)
        .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) { // "context" is only declared to follow the method signature provided by the interface
        if (value == null) {
            return true;
        }
        return acceptedValues.contains(value.toString());
    }}
