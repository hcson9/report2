package com.sparta.report.gold.dto;

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
   * 설명.
   */
  private String description;

  /**
   * 생성자.
   *
   * @param id          id
   * @param title       제목
   * @param description 설명
   */
  public ScheduleUpdateRequest(Long id, String title, String description) {
    this.id = id;
    this.title = title;
    this.description = description;
  }
}
