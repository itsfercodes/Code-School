package com.itsfercodes.code_school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itsfercodes.code_school.model.User;
import com.itsfercodes.code_school.service.UserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("public")
public class PublicController {

  @Autowired
  UserService userService;

  @GetMapping("/register")
  public String displatResgisterPage(Model model) {
    model.addAttribute("user", new User());
    return "register.html";
  }

  @PostMapping("/createUser")
  public String createUser(@Valid @ModelAttribute("user") User user, Errors errors) {
    if (errors.hasErrors()) {
      return "register.html";
    }
    if (userService.createNewUser(user)) {
      return "redirect:/login?register=true";
    }
    return "redirect:/login?register=false";

  }
}
