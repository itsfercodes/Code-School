package com.itsfercodes.code_school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

  @GetMapping("/contact")
  public String displayContactPage() {
    return "contact.html";
  }

  @PostMapping(value = "/saveMessage")
  public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum, @RequestParam String email,
      @RequestParam String subject, @RequestParam String message) {
    System.out.println("Name: " + name);
    System.out.println("Mobile Number: " + mobileNum);
    System.out.println("Email Address: " + email);
    System.out.println("Subject: " + subject);
    System.out.println("Message: " + message);

    return new ModelAndView("redirect:/contact");
  }
}
