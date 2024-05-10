package com.sparta.report.gold.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * create on 2024/05/09 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners({AuditingEntityListener.class})
public class Schedule {

  /**
   * 아이디.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 100, nullable = false)
  private String username;

  @Getter(AccessLevel.PRIVATE)
  @Column(length = 100, nullable = false)
  private String password;

  @Column
  private String title;

  @Column
  private String description;


  @CreationTimestamp
  @Column(nullable = false, updatable = false)
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
    this.title = title;
    this.description = description;
    this.username = username;
    this.password = password;
  }

  /**
   * 수정.
   *
   * @param title       제목
   * @param description 설명
   */
  public void update(String title, String description) {
    this.description = description;
    this.title = title;
  }
}
