package com.itsfercodes.code_school.service;

import org.springframework.stereotype.Service;

import com.itsfercodes.code_school.model.Contact;

@Service
public class ContactService {

  public boolean saveMessageDetails(Contact contact) {
    boolean isSaved = true;
    // TODO: Save the data into a database
    System.out.println(contact.toString());
    return isSaved;
  }
}
