package com.sparta.report.silver.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.sparta.report.silver.model.Schedule;
import com.sparta.report.silver.repository.ScheduleRepository;
import com.sparta.report.silver.service.ScheduleService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * create on 2024/05/10 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
class ScheduleServiceTest {

  private ScheduleRepository repository = Mockito.mock(ScheduleRepository.class);
  private ScheduleService service = new ScheduleService(repository);

  @Test
  void findByIdTest() {
    // given
    Schedule schedule = Mockito.mock(Schedule.class);

    // when
    when(repository.findById(any(Long.class)))
        .thenReturn(schedule);

    // then
    assertThat(service.findById(1)).isNotNull();
  }

  @Test
  void findAllTest() {
    // given
    List<Schedule> list = List.of(Mockito.mock(Schedule.class));

    // when
    when(repository.findAll()).thenReturn(list);

    // then
    assertThat(service.findAll()).isNotEmpty();
  }

  @Test
  void createTest() {
  }

  @Test
  void updateTest() {
  }

  @Test
  void deleteTest() {
  }
}