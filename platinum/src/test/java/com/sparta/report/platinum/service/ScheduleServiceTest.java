package com.sparta.report.platinum.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.sparta.report.platinum.dto.ScheduleCreateRequest;
import com.sparta.report.platinum.dto.ScheduleUpdateRequest;
import com.sparta.report.platinum.model.Schedule;
import com.sparta.report.platinum.repository.ScheduleRepository;
import java.util.List;
import java.util.Optional;
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
        .thenReturn(Optional.of(schedule));

    // then
    assertThat(service.findById(1)).isNotNull();
  }

  @Test
  void saveTest() {
    // given
    Schedule schedule = Mockito.mock(Schedule.class);
    ScheduleCreateRequest request = new ScheduleCreateRequest("123", "1234", "1235", "12354");

    // when
    when(repository.save(any())).thenReturn(schedule);

    // then
    assertThat(service.save(request)).isNotNull();
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
  void updateTest() {
    // given
    Schedule schedule = Mockito.mock(Schedule.class);
    ScheduleUpdateRequest request = new ScheduleUpdateRequest(1L, "1234", "1235");

    // when
    when(repository.findById(any(Long.class)))
        .thenReturn(Optional.of(schedule));

    // then
    assertThat(service.update(request))
        .isNotNull();
  }

  @Test
  void deleteTest() {
    // given
    Schedule schedule = Mockito.mock(Schedule.class);

    //when
    when(repository.findById(any(Long.class)))
        .thenReturn(Optional.of(schedule));

    // then
    assertDoesNotThrow(() -> service.delete(1L));
  }
}