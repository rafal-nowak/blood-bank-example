package com.amigoscode.bbexample.domain.provider;

import com.amigoscode.bbexample.domain.user.User;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

@Value
public class PageProvider implements Serializable {

    List<Provider> providers;
    Integer currentPage;
    Integer totalPages;
    Long totalElements;
}
