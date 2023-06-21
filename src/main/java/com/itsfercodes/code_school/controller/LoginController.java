package com.itsfercodes.code_school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

  @GetMapping("/login")
  @PostMapping(value = "/login")
  public String displayLoginPage(@RequestParam(value = "error", required = false) String error,
      @RequestParam(value = "logout", required = false) String logout, Model model) {

    String errorMessage = null, logoutMessage = null;
    if (error != null) {
      errorMessage = "Username or Password is incorrect. Please try again";
    }
    if (logout != null) {
      logoutMessage = "You have been successfully logged out";
    }
    model.addAttribute("errorMessage", errorMessage);
    model.addAttribute("logoutMessage", logoutMessage);
    return "login.html";
  }

}