package com.amigoscode.bbexample.api.user;

import java.util.List;

public record PageUserDto(
        List<UserDto> users,
        Integer currentPage,
        Integer totalPages,
        Long totalElements
) {
}
