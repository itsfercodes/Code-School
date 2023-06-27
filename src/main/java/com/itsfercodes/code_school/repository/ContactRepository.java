package com.itsfercodes.code_school.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.itsfercodes.code_school.model.Contact;
import com.itsfercodes.code_school.rowmappers.ContactRowMapper;

@Repository
public class ContactRepository {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public ContactRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public int saveContactMessage(Contact contact) {
    String query = "INSERT INTO contact_msg (name, mobile_num, email, subject, message, status, created_at, created_by) values (?,?,?,?,?,?,?,?)";
    return jdbcTemplate.update(query, contact.getName(), contact.getMobileNum(), contact.getEmail(),
        contact.getSubject(), contact.getMessage(), contact.getStatus(), contact.getCreatedAt(),
        contact.getCreatedBy());
  }

  public List<Contact> findMessagesByStatus(String status) {
    String query = "SELECT * FROM contact_msg WHERE status = ?";
    return jdbcTemplate.query(query, new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, status);
      }
    }, new ContactRowMapper());
  }

  public int updateMessageStatus(int contactId, String updatedBy, String status) {
    String query = "UPDATE contact_msg SET status = ?, updated_by = ?, updated_at = ? WHERE contact_id = ?";
    return jdbcTemplate.update(query, new PreparedStatementSetter() {
      public void setValues(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, status);
        preparedStatement.setString(2, updatedBy);
        preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
        preparedStatement.setInt(4, contactId);
      }
    });
  }
}
