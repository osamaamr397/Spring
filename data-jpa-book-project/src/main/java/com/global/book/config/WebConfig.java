package com.global.book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
//auditorAware ->this is the name of the bean which is the function name
public class WebConfig {
    @Bean
    public AuditorAware<String>auditorAware(){
            return new AuditorAwareImpl();//here i inject the AuditorAwareImpl through @Configuration
    }
}
