package com.itsfercodes.code_school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping(value = { "", "/" })
  public String displayHomePage() {
    return "index.html";
  }

}
