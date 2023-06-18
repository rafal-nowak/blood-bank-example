package com.amigoscode.bbexample.api.auth;

public record AuthenticationRequest(
        String username,
        String password
) {
}
