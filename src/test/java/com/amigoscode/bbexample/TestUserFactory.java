package com.amigoscode.bbexample;


import com.amigoscode.bbexample.domain.user.User;
import com.amigoscode.bbexample.domain.user.UserRole;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TestUserFactory {

    private static int userSequence = 10;

    public static User createAdmin() {
        userSequence++;
        return new User(
                userSequence,
                "newUser" + userSequence + "@example.com",
                "User Name " + userSequence,
                "password",
                UserRole.ADMIN,
                ZonedDateTime.of(2023, 6, 17, 12, 40, 00, 0, ZoneId.of("UTC"))
        );
    }

    public static User createTechnologist() {
        userSequence++;
        return new User(
                userSequence,
                "newUser" + userSequence + "@example.com",
                "User Name " + userSequence,
                "password",
                UserRole.TECHNOLOGIST,
                ZonedDateTime.of(2023, 6, 17, 12, 40, 00, 0, ZoneId.of("UTC"))
        );
    }

    public static User createMedicalDoctor() {
        userSequence++;
        return new User(
                userSequence,
                "newUser" + userSequence + "@example.com",
                "User Name " + userSequence,
                "password",
                UserRole.MEDICAL_DOCTOR,
                ZonedDateTime.of(2023, 6, 17, 12, 40, 00, 0, ZoneId.of("UTC"))
        );
    }
}
