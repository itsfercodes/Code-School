package com.itsfercodes.code_school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.itsfercodes.code_school.model.Contact;
import com.itsfercodes.code_school.service.ContactService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ContactController {

  private final ContactService contactService;

  // Is optional as it is only one constructor, if there are more then it will
  // require it
  // @Autowired
  public ContactController(ContactService contactService) {
    this.contactService = contactService;
  }

  // Endpoints
  @GetMapping("/contact-us")
  public String displayContactPage(Model model) {
    model.addAttribute("contact", new Contact());
    return "contact.html";
  }

  @PostMapping(value = "/saveMessage")
  // The @ModelAttribute means that there is a model attribute named contact that
  // is binded to the object contact. @Valid let spring know that there are
  // validation inside the object
  public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {

    // If there are errors the fields will not be empty once the page is reloaded
    if (errors.hasErrors()) {
      log.error("Contact form validation failed due to: " + errors.toString());
      return "contact.html";
    }

    contactService.saveMessageDetails(contact);
    contactService.setCounter(contactService.getCounter() + 1);
    log.info("Number of times the contact form is submitted: " + contactService.getCounter());
    // With redirect we mean that it will not process any information of the
    // template engine, as it was new
    return "redirect:/contact-us";
  }
}
