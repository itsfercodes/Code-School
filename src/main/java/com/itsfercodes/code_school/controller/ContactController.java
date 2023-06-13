package com.itsfercodes.code_school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itsfercodes.code_school.model.Contact;
import com.itsfercodes.code_school.service.ContactService;

@Controller
public class ContactController {

  private final ContactService contactService;

  // Is optional as it is only on constructor, if there are more then it will
  // require it
  // @Autowired
  public ContactController(ContactService contactService) {
    this.contactService = contactService;
  }

  // Endpoints
  @GetMapping("/contact-us")
  public String displayContactPage() {
    return "contact.html";
  }

  @PostMapping(value = "/saveMessage")
  public ModelAndView saveMessage(Contact contact) {
    contactService.saveMessageDetails(contact);
    return new ModelAndView("redirect:/contact");
  }
}
