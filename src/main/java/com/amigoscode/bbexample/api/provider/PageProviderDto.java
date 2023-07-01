package com.amigoscode.bbexample.api.provider;

import com.amigoscode.bbexample.api.user.UserDto;

import java.util.List;

public record PageProviderDto(
        List<ProviderDto> providers,
        Integer currentPage,
        Integer totalPages,
        Long totalElements
) {
}
