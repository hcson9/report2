package com.sparta.report.platinum.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.given;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * create on 2024/05/13 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
class ScheduleTest {

  @Test
  void updateTest() {
    Schedule schedule = new Schedule("123", "333", "hc@gmail.com","123");
    String title = "1234";
    String description = "ㅌ세트테스트";

    schedule.update(title, description);

    assertThat(schedule.getTitle()).isEqualTo(title);
    assertThat(schedule.getDescription()).isEqualTo(description);

    assertThat(schedule.getId()).isNull();
    assertThat(schedule.getUsername()).isNotNull();
    assertThat(schedule.getPassword()).isNotNull();
  }
}