package com.itsfercodes.code_school.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsfercodes.code_school.constants.CodeSchoolConstants;
import com.itsfercodes.code_school.model.Contact;
import com.itsfercodes.code_school.repository.ContactRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ContactService {

  @Autowired
  private ContactRepository contactRepository;

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
    boolean isSaved = false;

    contact.setStatus(CodeSchoolConstants.OPEN);

    Contact savedContact = contactRepository.save(contact);

    if (savedContact != null && savedContact.getContactId() > 0)
      isSaved = true;

    return isSaved;
  }

  public List<Contact> findOpenStatusMessages() {
    List<Contact> contactMessages = contactRepository.findByStatus(CodeSchoolConstants.OPEN);
    return contactMessages;
  }

  public boolean updateMessageStatus(int contactId) {
    boolean isUpdated = false;
    Optional<Contact> contact = contactRepository.findById(contactId);
    contact.ifPresent(attributes -> {
      attributes.setStatus(CodeSchoolConstants.CLOSE);
    });

    Contact updatedContact = contactRepository.save(contact.get());
    if (updatedContact != null && updatedContact.getUpdatedBy() != null)
      isUpdated = true;

    return isUpdated;
  }

}
