package com.itsfercodes.code_school.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DashboardController {

  @GetMapping("/dashboard")
  public String displayDashboard(Model model, Authentication authentication) {
    model.addAttribute("username", authentication.getName());
    model.addAttribute("roles", authentication.getAuthorities().toString());
    return "dashboard.html";
  }

}
