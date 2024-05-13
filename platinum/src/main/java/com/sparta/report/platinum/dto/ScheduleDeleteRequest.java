package com.sparta.report.platinum.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(name = "schedule delete request", description = "스케쥴 삭제 요청")
public class ScheduleDeleteRequest {

  /**
   * id.
   */
  @NotNull
  @Schema(name = "id", description = "아이디", example = "1")
  private Long id;

  /**
   * 비밀번호.
   */
  @NotNull
  @Schema(name = "password", description = "비밀번호", example = "password")
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
