package com.itsfercodes.code_school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsfercodes.code_school.constants.CodeSchoolConstants;
import com.itsfercodes.code_school.model.Role;
import com.itsfercodes.code_school.model.User;
import com.itsfercodes.code_school.repository.RolesRepository;
import com.itsfercodes.code_school.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  RolesRepository rolesRepository;

  public boolean createNewUser(User user) {
    boolean isSaved = false;
    Role role = rolesRepository.getByRoleName(CodeSchoolConstants.STUDENT_ROLE);
    user.setRoles(role);
    user = userRepository.save(user);
    if (user != null && user.getId() > 0) {
      isSaved = true;
    }
    return isSaved;
  }
}
