package com.amigoscode.bbexample.config;

import com.amigoscode.bbexample.domain.user.EncodingService;
import com.amigoscode.bbexample.domain.user.UserRepository;
import com.amigoscode.bbexample.domain.user.UserService;
import com.amigoscode.bbexample.external.storage.user.JpaUserRepository;
import com.amigoscode.bbexample.external.storage.user.UserEntityMapper;
import com.amigoscode.bbexample.external.storage.user.UserStorageAdapter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
@ConfigurationProperties("domain.properties")
public class DomainConfiguration {

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }

    @Bean
    public UserRepository userRepository(JpaUserRepository jpaUserRepository, UserEntityMapper mapper) {
        return new UserStorageAdapter(jpaUserRepository, mapper);
    }

    @Bean
    public UserService userService(UserRepository userRepository, EncodingService encoder, Clock clock)  {
        return new UserService(userRepository, encoder, clock);
    }

}
