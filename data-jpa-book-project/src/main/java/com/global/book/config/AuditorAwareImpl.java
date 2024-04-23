package com.global.book.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    //string as the data type of auditing are string
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("test user");
    }
}
