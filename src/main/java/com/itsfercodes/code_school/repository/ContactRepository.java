package com.itsfercodes.code_school.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itsfercodes.code_school.model.Contact;

@Repository
public class ContactRepository {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public ContactRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public int saveContactMessage(Contact contact) {

    String query = "INSERT INTO CONTACT_MSG (NAME, MOBILE_NUM, EMAIL, SUBJECT, MESSAGE, STATUS, CREATED_AT, CREATED_BY) VALUES (?,?,?,?,?,?,?,?)";
    return jdbcTemplate.update(query, contact.getName(), contact.getMobileNum(), contact.getEmail(),
        contact.getSubject(), contact.getMessage(), contact.getStatus(), contact.getCreatedAt(),
        contact.getCreatedBy());
  }
}
