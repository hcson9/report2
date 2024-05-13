package com.sparta.report.platinum.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
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
@Schema(name = "schedule update request", description = "스케쥴 수정 요청")
public class ScheduleUpdateRequest {

  /**
   * id.
   */
  @NotNull
  @Schema(name = "id", description = "아이디", example = "1")
  private Long id;

  /**
   * title.
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
