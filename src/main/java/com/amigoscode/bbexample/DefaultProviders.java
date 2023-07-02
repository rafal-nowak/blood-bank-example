package com.amigoscode.bbexample;

import com.amigoscode.bbexample.domain.provider.Provider;
import com.amigoscode.bbexample.domain.provider.ProviderService;
import com.amigoscode.bbexample.domain.user.User;
import com.amigoscode.bbexample.domain.user.UserRole;
import com.amigoscode.bbexample.domain.user.UserService;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

import static java.security.Security.addProvider;

@Component
@Order(2)
@Log
public class DefaultProviders implements CommandLineRunner {

    private final ProviderService providerService;

    public DefaultProviders(ProviderService providerService) {
        this.providerService = providerService;
    }

    private final Provider provider1 = new Provider(
            null,
            "John",
            "provider.john@gmail.com",
            ZonedDateTime.now(),
            1
    );

    private final Provider provider2 = new Provider(
            null,
            "Sue",
            "provider.sue@gmail.com",
            ZonedDateTime.now(),
            1
    );

    private final Provider provider3 = new Provider(
            null,
            "Angela",
            "provider.angela@gmail.com",
            ZonedDateTime.now(),
            1
    );

    @Override
    public void run(String... args) {
        try {
            addProvider(provider1);
            addProvider(provider2);
            addProvider(provider3);

        } catch (Exception ex) {
            log.warning(ex.getMessage());
        }
    }

    private void addProvider(Provider provider) {
        providerService.save(provider);
    }
}
