package com.amigoscode.bbexample.domain.user;

public enum UserRole {

    ADMIN ("ADMIN"),
    TECHNOLOGIST ("TECHNOLOGIST"),
    MEDICAL_DOCTOR ("MEDICAL_DOCTOR");


    private final String value;

    UserRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
