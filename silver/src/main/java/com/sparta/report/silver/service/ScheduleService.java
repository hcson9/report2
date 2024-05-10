package com.sparta.report.silver.service;

import com.sparta.report.silver.dto.ScheduleCreateRequest;
import com.sparta.report.silver.dto.ScheduleResponse;
import com.sparta.report.silver.dto.ScheduleUpdateRequest;
import com.sparta.report.silver.model.Schedule;
import com.sparta.report.silver.repository.ScheduleRepository;
import java.util.Comparator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * create on 2024/05/10 create by IntelliJ IDEA.
 *
 * <p> 일정 관리. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class ScheduleService {

  private final ScheduleRepository repository;


  /**
   * id 로 일정찾기.
   *
   * @param id id
   * @return 응답.
   */
  public ScheduleResponse findById(long id) {
    return ScheduleResponse.toDto(repository.findById(id));
  }

  /**
   * 저장.
   *
   * @param request 저장 요청
   * @return 생성 된 응답
   */
  public ScheduleResponse save(ScheduleCreateRequest request) {
    Schedule schedule = repository.save(request.toEntity());
    return ScheduleResponse.toDto(schedule);
  }

  /**
   * 전체 검색.
   *
   * @return 조회된 리스트
   */
  public List<ScheduleResponse> findAll() {
    List<Schedule> list = repository.findAll();
    return list
        .stream()
        .sorted(Comparator.comparing(Schedule::getCreatedAt).reversed())
        .map(s -> ScheduleResponse.toDto(s))
        .toList();
  }

  /**
   * 수정 요청.
   *
   * @param request 수정 요청
   * @return 수정된 응답 값
   */
  public ScheduleResponse update(ScheduleUpdateRequest request) {
    return ScheduleResponse.toDto(repository.update(null));
  }

  /**
   * 삭제.
   *
   * @param id 삭제할 id
   */
  public void delete(long id) {
    repository.delete(id);
  }
}
