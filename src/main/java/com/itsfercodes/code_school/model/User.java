package com.itsfercodes.code_school.model;

import com.itsfercodes.code_school.annotations.FieldsValueMatch;
import com.itsfercodes.code_school.annotations.PasswordValidator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@FieldsValueMatch.List({
    @FieldsValueMatch(field = "password", fieldMatch = "confirmPassword", message = "Passwords do not match"),
    @FieldsValueMatch(field = "email", fieldMatch = "confirmEmail", message = "Emails do not match")
})
public class User extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotBlank(message = "Name must not be blank")
  @Size(min = 3, message = "Name must be at least 3 characters long")
  private String name;

  @NotBlank(message = "Mobile number must not be blank")
  @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
  private String mobileNumber;

  @NotBlank(message = "Email must not be blank")
  @Email(message = "Please provide a valid email address")
  private String email;

  @NotBlank(message = "Confirm Email must not be blank")
  @Email(message = "Please provide a valid confirm email address")
  @Transient
  private String confirmEmail;

  @NotBlank(message = "Password must not be blank")
  @Size(min = 5, message = "Password must be at least 5 characters long")
  @PasswordValidator
  private String password;

  @NotBlank(message = "Confirm Password must not be blank")
  @Size(min = 5, message = "Confirm must be at least 5 characters long")
  @Transient
  private String confirmPassword;
}
