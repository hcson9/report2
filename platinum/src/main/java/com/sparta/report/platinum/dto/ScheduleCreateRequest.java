package com.sparta.report.platinum.dto;

import com.sparta.report.platinum.model.Schedule;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

/**
 * create on 2024/05/10 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @see Schedule
 * @since 1.0
 */
@Getter
@Schema(name = "schedule create request", description = "스케쥴 생성 요청")
public class ScheduleCreateRequest {

  /**
   * userid.
   */
  @NotNull
  @Schema(name = "username", description = "담당자", example = "user1234@gmail.com")
  @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$",
      message = "이메일 형식이 올바르지 않습니다.")
  private String username;

  /**
   * 비밀번호.
   */
  @NotNull
  @Schema(name = "password", description = "비밀번호", example = "password")
  private String password;

  /**
   * 제목.
   */
  @NotNull
  @Schema(name = "title", description = "제목", example = "안녕하세요")
  @Max(value = 200)
  private String title;

  /**
   * 설명.
   */
  @Schema(name = "description", description = "상세", example = "안녕하세요!!!")
  private String description;


  /**
   * 생성자.
   *
   * @param title       제목
   * @param password    비밀번호
   * @param description 설명
   * @param username    유저id
   */
  public ScheduleCreateRequest(String title, String password, String description, String username) {
    this.title = title;
    this.password = password;
    this.description = description;
    this.username = username;
  }

  /**
   * Schedule 생성.
   *
   * @return 생성된 {@code Schedule}
   */
  public Schedule toEntity() {
    return new Schedule(this.title,
        this.description,
        this.username,
        this.password);
  }
}
