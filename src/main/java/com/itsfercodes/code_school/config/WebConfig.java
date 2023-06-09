package com.itsfercodes.code_school.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Helps to map static pages that doesn't require any controller logic behind, saving us 
// to create a controller to only display a static page
@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/courses").setViewName("courses");
    registry.addViewController("/about").setViewName("about");
  }
}
