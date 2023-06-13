package com.itsfercodes.code_school.service;

import org.springframework.stereotype.Service;

import com.itsfercodes.code_school.model.Contact;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ContactService {

  /**
   * Save Contact details into DB
   * 
   * @param contact
   * @return boolean
   */
  public boolean saveMessageDetails(Contact contact) {
    boolean isSaved = true;
    // TODO: Save the data into a database
    log.info(contact.toString());
    return isSaved;
  }
}
