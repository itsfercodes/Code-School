package com.itsfercodes.code_school.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

  String[] staticResources = { "/assets/**", "/holidays/**", "/courses", "/contact-us", "/", "/about" };

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

    http.authorizeHttpRequests((authz) -> authz
        // Public
        .requestMatchers(staticResources).permitAll());
    return http.build();
  }
}
