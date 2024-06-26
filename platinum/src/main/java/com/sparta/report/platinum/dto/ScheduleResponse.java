package com.sparta.report.platinum.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sparta.report.platinum.model.Schedule;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Getter;

/**
 * create on 2024/05/10 create by IntelliJ IDEA.
 *
 * <p> 스케쥴 응답 정보. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
@Getter
@Schema(name = "schedule response", description = "스케쥴 응답")
public class ScheduleResponse {

  /**
   * 아이디.
   */
  @Schema(name = "id", description = "아이디", example = "1")
  private Long id;

  /**
   * 제목.
   */
  @Schema(name = "title", description = "제목", example = "안녕하세요")
  private String title;

  /**
   * 설명.
   */
  @Schema(name = "description", description = "상세", example = "안녕하세요!!!")
  private String description;

  /**
   * userID.
   */
  @Schema(name = "username", description = "유저 이름", example = "user1234")
  private String username;

  /**
   * 생성일자.
   */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @Schema(name = "createdAt",
      description = "생성일",
      example = "2024-02-01 12:00:00",
      pattern = "yyyy-MM-dd HH:mm:ss",
      type = "string")
  private LocalDateTime createdAt;

  /**
   * 생성자.
   *
   * @param id          id
   * @param title       제목
   * @param description 설명
   * @param username    userid
   * @param createdAt   생성일자
   */
  public ScheduleResponse(Long id, String title, String description, String username,
      LocalDateTime createdAt) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.username = username;
    this.createdAt = createdAt;
  }

  /**
   * Schedule 을 dto 로 변환.
   *
   * @param schedule 변환할 스케쥴
   * @return response
   */
  public static ScheduleResponse toDto(Schedule schedule) {
    return new ScheduleResponse(schedule.getId(),
        schedule.getTitle(),
        schedule.getDescription(),
        schedule.getUsername(),
        schedule.getCreatedAt());
  }
}
