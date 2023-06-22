package com.itsfercodes.code_school.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BaseEntity {
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private String createdBy;
  private String updatedBy;
}