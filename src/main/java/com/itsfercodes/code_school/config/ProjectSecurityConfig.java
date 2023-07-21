package com.itsfercodes.code_school.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@ComponentScan("com.itsfercodes.code_school.security")
public class ProjectSecurityConfig {

  String[] publicResources = { "/assets/**", "/holidays/**", "/courses", "/contact-us", "/", "", "/about", "/login",
      "/logout", "/saveMessage", "/error", "/public/**" };
  String[] authenticationResources = { "/dashboard" };
  String[] adminResources = { "/displayMessages/**", "/closeMessage/**" };
  String[] csrfIgnoreList = { "/saveMessage", "/public/**" };

  @Bean
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

    http.csrf(csrf -> csrf.ignoringRequestMatchers(csrfIgnoreList))

        .authorizeHttpRequests((requests) -> requests
            // Public
            .requestMatchers(publicResources).permitAll()

            // Require authentication
            .requestMatchers(authenticationResources).authenticated()

            // Require ADMIN role
            .requestMatchers(adminResources).hasRole("ADMIN"))
        .formLogin(login -> login
            .loginPage("/login")
            .defaultSuccessUrl("/dashboard")
            .failureUrl("/login?error=true")
            .permitAll())
        .logout(logoutConfigurer -> logoutConfigurer.logoutSuccessUrl("/login?logout=true")
            .invalidateHttpSession(true).permitAll())
        .httpBasic(Customizer.withDefaults());

    return http.build();
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
