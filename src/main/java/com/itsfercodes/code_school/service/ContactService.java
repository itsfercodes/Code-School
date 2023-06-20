package com.itsfercodes.code_school.service;

import org.springframework.stereotype.Service;

import com.itsfercodes.code_school.model.Contact;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ContactService {

  private int counter = 0;

  public ContactService() {
    System.out.println("Contact service initilazed!");
  }

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

  public int getCounter() {
    return counter;
  }

  public void setCounter(int counter) {
    this.counter = counter;
  }

}
