package com.itsfercodes.code_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itsfercodes.code_school.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
