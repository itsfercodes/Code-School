package com.itsfercodes.code_school.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "holidays")
public class Holiday extends BaseEntity {

  public enum Type {
    FESTIVAL, FEDERAL
  }

  @Id
  private String day;
  private String reason;

  @Enumerated(EnumType.STRING)
  private Type type;

}
