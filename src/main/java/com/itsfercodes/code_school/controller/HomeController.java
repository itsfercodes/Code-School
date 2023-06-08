package com.itsfercodes.code_school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping(value = { "", "/" })
  // model is a container to hold the values for the template to be rendered
  public String displayHomePage(Model model) {
    // model works as a key value structure. Key should be the same as in the
    // template
    model.addAttribute("username", "Fernando");
    return "index.html";
  }

}
