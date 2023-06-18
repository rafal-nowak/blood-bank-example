package com.amigoscode.bbexample.api.auth;

import com.amigoscode.bbexample.api.user.UserDto;

public record AuthenticationResponse(
        String token,
        UserDto userDto
) {
}
