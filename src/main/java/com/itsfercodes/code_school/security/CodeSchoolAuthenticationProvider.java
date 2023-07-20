package com.itsfercodes.code_school.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.itsfercodes.code_school.model.Role;
import com.itsfercodes.code_school.model.User;
import com.itsfercodes.code_school.repository.UserRepository;

@Component
public class CodeSchoolAuthenticationProvider implements AuthenticationProvider {
  @Autowired
  private UserRepository userRepository;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!11111");
    String email = authentication.getName();
    String password = authentication.getCredentials().toString();
    User user = userRepository.findByEmail(email);

    if (user != null && user.getUser_id() > 0 && password.equals(user.getPassword())) {
      return new UsernamePasswordAuthenticationToken(user.getName(), password, getGrantedAuthorities(user.getRoles()));
    } else {
      throw new BadCredentialsException("Invalid credentials");
    }
  }

  private List<GrantedAuthority> getGrantedAuthorities(Role roles) {
    List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + roles.getRoleName()));
    return grantedAuthorities;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}
