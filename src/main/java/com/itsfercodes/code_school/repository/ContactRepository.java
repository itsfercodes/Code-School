package com.itsfercodes.code_school.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.itsfercodes.code_school.model.Contact;

public interface ContactRepository extends ListCrudRepository<Contact, Integer> {
  List<Contact> findByStatus(String status);
}
