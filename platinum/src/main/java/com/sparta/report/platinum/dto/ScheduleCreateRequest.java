package com.sparta.report.platinum.dto;

import com.sparta.report.platinum.model.Schedule;
import jakarta.validation.constraints.NotNull;
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
public class ScheduleCreateRequest {

  /**
   * userid.
   */
  @NotNull
  private String username;

  /**
   * 비밀번호.
   */
  @NotNull
  private String password;

  /**
   * 제목.
   */
  @NotNull
  private String title;

  /**
   * 설명.
   */
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
