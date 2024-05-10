package com.sparta.report.gold.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

/**
 * create on 2024/05/10 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
@Getter
public class ScheduleDeleteRequest {

  /**
   * id.
   */
  @NotNull
  private Long id;

  /**
   * 비밀번호.
   */
  @NotNull
  private String password;

  /**
   * 생성자.
   *
   * @param id       id
   * @param password 비밀번호
   */
  public ScheduleDeleteRequest(Long id, String password) {
    this.id = id;
    this.password = password;
  }
}
