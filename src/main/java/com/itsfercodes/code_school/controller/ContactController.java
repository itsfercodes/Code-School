package com.itsfercodes.code_school.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itsfercodes.code_school.model.Contact;
import com.itsfercodes.code_school.service.ContactService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class ContactController {

  private final ContactService contactService;

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
  public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors,
      RedirectAttributes redirectAttributes) {

    // If there are errors the fields will not be empty once the page is reloaded
    if (errors.hasErrors()) {
      log.error("Contact form validation failed due to: " + errors.toString());
      return "contact.html";
    }

    if (contactService.saveMessageDetails(contact)) {
      redirectAttributes.addFlashAttribute("savedMessage",
          "Information submitted successfully! Expect a call from us soon");
    } else {
      redirectAttributes.addFlashAttribute("savedMessage", "Error while saving message, please try again later");
    }
    return "redirect:/contact-us";
  }

  @GetMapping("/displayMessages")
  public ModelAndView displayMessages(Model model) {
    List<Contact> contactMessages = contactService.findOpenStatusMessages();
    ModelAndView modelAndView = new ModelAndView("messages.html");
    modelAndView.addObject("contactMessages", contactMessages);
    return modelAndView;
  }

  @GetMapping("/closeMessage")
  public String closeMessage(@RequestParam int id, Authentication authentication,
      RedirectAttributes redirectAttributes) {

    if (contactService.updateMessageStatus(id, authentication.getName())) {
      redirectAttributes.addFlashAttribute("updated",
          "Message status updated succesfully!");
    } else {
      redirectAttributes.addFlashAttribute("notUpdated",
          "Error while updating message, please inform about this error");
    }

    return "redirect:/displayMessages";
  }

}
