package com.itsfercodes.code_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itsfercodes.code_school.model.Role;

public interface RolesRepository extends JpaRepository<Role, Integer> {

}
