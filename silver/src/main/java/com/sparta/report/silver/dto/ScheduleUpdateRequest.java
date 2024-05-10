package com.sparta.report.silver.dto;

import com.sparta.report.silver.model.Schedule;
import lombok.Getter;

/**
 * create on 2024/05/10 create by IntelliJ IDEA.
 *
 * <p> 수정요청. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
@Getter
public class ScheduleUpdateRequest {

  /**
   * id.
   */
  private Long id;

  /**
   * title.
   */
  private String title;

  /**
   * 비밀번호.
   */
  private String password;

  /**
   * 설명.
   */
  private String description;

  /**
   * 유저 id.
   */
  private String username;

  /**
   * 생성자.
   *
   * @param id          id
   * @param title       제목
   * @param password    패스워드
   * @param description 설명
   * @param username    유저명
   */
  public ScheduleUpdateRequest(Long id, String title, String password, String description,
      String username) {
    this.id = id;
    this.title = title;
    this.password = password;
    this.description = description;
    this.username = username;
  }
}
