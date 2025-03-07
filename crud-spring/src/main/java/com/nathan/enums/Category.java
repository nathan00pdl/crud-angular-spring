package com.nathan.enums;

// ENUM -> Defining strongly typed fixed values.

public enum Category {
    BACKEND("Back-end"), 
    FRONTEND("Front-end");

    private final String value;

    Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}   
