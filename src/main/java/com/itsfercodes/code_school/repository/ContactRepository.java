package com.itsfercodes.code_school.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.itsfercodes.code_school.model.Contact;

@Repository
public interface ContactRepository extends ListCrudRepository<Contact, Integer> {
  List<Contact> findByStatus(String status);
}
