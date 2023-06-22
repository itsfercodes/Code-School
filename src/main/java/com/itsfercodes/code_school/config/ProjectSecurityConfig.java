package com.itsfercodes.code_school.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

  String[] publicResources = { "/assets/**", "/holidays/**", "/courses", "/contact-us", "/", "", "/about", "/login",
      "/logout", "/saveMessage" };
  String[] authenticationResources = { "/dashboard" };

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

    http.csrf(csrf -> csrf.ignoringRequestMatchers("/saveMessage").ignoringRequestMatchers(PathRequest.toH2Console()));

    http.authorizeHttpRequests((authz) -> authz
        // Public
        .requestMatchers(publicResources).permitAll()
        .requestMatchers(PathRequest.toH2Console()).permitAll()
        // Require authentication
        .requestMatchers(authenticationResources).authenticated());

    // Login page
    http.formLogin(login -> login
        .loginPage("/login")
        .defaultSuccessUrl("/dashboard")
        .failureUrl("/login?error=true")
        .permitAll());

    http.headers().frameOptions().disable();

    return http.build();
  }

  // TODO: Create db to store user details
  // Creates temporary user and admin credentials
  @Bean
  InMemoryUserDetailsManager userDetailsService() {
    UserDetails user = User.withDefaultPasswordEncoder()
        .username("user")
        .password("12345")
        .roles("USER")
        .build();

    UserDetails admin = User.withDefaultPasswordEncoder()
        .username("admin")
        .password("54321")
        .roles("USER", "ADMIN")
        .build();

    return new InMemoryUserDetailsManager(user, admin);
  }
}
