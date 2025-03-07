package com.nathan.enums;

/*
 * Notes:
 * 
 * ENUM -> Defining strongly typed fixed values.
 * 
 * Category.BACKEND.name() returns "BACKEND"
 * Category.BACKEND.getValue() returns "Back-end"
 * Category.BACKEND.toString() also returns "Back-end"
 */

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
