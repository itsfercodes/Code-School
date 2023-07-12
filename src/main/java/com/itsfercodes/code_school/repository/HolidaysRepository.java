package com.itsfercodes.code_school.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.itsfercodes.code_school.model.Holiday;

// CrudRepository<POJO, PK Type>
public interface HolidaysRepository extends ListCrudRepository<Holiday, String> {

}
