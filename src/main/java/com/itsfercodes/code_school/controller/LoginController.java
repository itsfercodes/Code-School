package com.itsfercodes.code_school.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

  @GetMapping("/login")
  @PostMapping(value = "/login")
  public String displayLoginPage(
      @RequestParam(value = "error", required = false) String error,
      @RequestParam(value = "logout", required = false) String logout, Model model,
      @RequestParam(value = "register", required = false) String register) {

    String errorMessage = null, logoutMessage = null, registerMessageSuccessful = null, registerMessageFailure = null;
    if (error != null) {
      errorMessage = "Username or Password is incorrect. Please try again";
    }
    if (logout != null) {
      logoutMessage = "You have been successfully logged out";
    }
    if (register != null && register.equals("true")) {
      registerMessageSuccessful = "User created successfully! Please login";
    } else if (register != null) {
      registerMessageFailure = "User could not be created! Please inform about this";
    }
    model.addAttribute("errorMessage", errorMessage);
    model.addAttribute("logoutMessage", logoutMessage);
    model.addAttribute("registerMessageSuccessful", registerMessageSuccessful);
    model.addAttribute("registerMessageFailure", registerMessageFailure);
    return "login.html";
  }

  @GetMapping("/logout")
  public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null) {
      new SecurityContextLogoutHandler().logout(request, response, auth);
    }
    return "redirect:/login?logout=true";
  }

}
