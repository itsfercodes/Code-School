package com.itsfercodes.code_school.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.itsfercodes.code_school.model.Holiday;

@Repository
// CrudRepository<POJO, PK Type>
public interface HolidaysRepository extends ListCrudRepository<Holiday, String> {

}
