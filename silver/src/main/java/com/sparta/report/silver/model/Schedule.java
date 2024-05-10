package com.sparta.report.silver.model;

import com.sparta.report.silver.repository.ScheduleRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AccessLevel;
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
public class Schedule {

  /**
   * 아이디.
   */
  private Long id;

  /**
   * 제목.
   */
  private String title;

  /**
   * 설명.
   */
  private String description;

  /**
   * 유저명.
   */
  private String username;

  /**
   * 패스워드.
   */
  private String password;

  /**
   * 생성일.
   */
  private LocalDateTime createdAt;

  /**
   * 생성자.
   *
   * @param title       제목
   * @param description 설명
   * @param username    유저 명
   * @param password    패스워드
   */
  public Schedule(String title, String description, String username, String password) {
    this.id = ScheduleRepository.getNextId();
    this.title = title;
    this.description = description;
    this.username = username;
    this.password = password;
    this.createdAt = LocalDateTime.now();
  }
}
