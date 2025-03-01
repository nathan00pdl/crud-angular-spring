package com.nathan.enums;

/*
 * Note:
 * 
 * The constructor does not need the acces modifer, as java automatically manages the instances of the ENUM values. 
 * Allowing an ENUM constructor to be public would make it possible to create new instances, thus going against the purpose of an ENUM object.
 */

public enum UserRole {
    ADMIN("admin"), 
    USER("user");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
