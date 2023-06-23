package com.itsfercodes.code_school.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Holiday extends BaseEntity {

  public enum Type {
    FESTIVAL, FEDERAL
  }

  private String day;
  private String reason;
  private Type type;

}
