package com.sparta.report.gold.controller;

import com.sparta.report.gold.dto.ScheduleCreateRequest;
import com.sparta.report.gold.dto.ScheduleDeleteRequest;
import com.sparta.report.gold.dto.ScheduleResponse;
import com.sparta.report.gold.dto.ScheduleUpdateRequest;
import com.sparta.report.gold.service.ScheduleService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create on 2024/05/10 create by IntelliJ IDEA.
 *
 * <p> 스케쥴 컨트롤러.. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/schedule")
@Slf4j
@RequiredArgsConstructor
public class ScheduleController {

  private final ScheduleService service;

  /**
   * 조회.
   *
   * @param id 조회할 id
   * @return 조회된 스케쥴
   */
  @GetMapping("/{id}")
  public ResponseEntity<ScheduleResponse> findById(@PathVariable(name = "id") long id) {
    return ResponseEntity.ok()
        .body(service.findById(id));
  }

  /**
   * 일정 전체 조회.
   *
   * @return 조회된 리스트
   */
  @GetMapping("")
  public ResponseEntity<List<ScheduleResponse>> findAll() {
    return ResponseEntity.ok()
        .body(service.findAll());
  }

  /**
   * 생성.
   *
   * @param request 생성 요청
   * @return 생성된 정보
   */
  @PostMapping("")
  public ResponseEntity<ScheduleResponse> create(
      @Valid @RequestBody ScheduleCreateRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request));
  }

  /**
   * 수정 요청.
   *
   * @param request 수정 요청
   * @return 수정된 정보.
   */
  @PutMapping("")
  public ResponseEntity<ScheduleResponse> update(
      @Valid @RequestBody ScheduleUpdateRequest request) {
    return ResponseEntity.ok().body(service.update(request));
  }

  /**
   * 삭제.
   *
   * @param request 삭제할 정보
   * @return 삭제정보.
   */
  @DeleteMapping("")
  public ResponseEntity<String> delete(@Valid @RequestBody ScheduleDeleteRequest request) {
    service.delete(request);
    return ResponseEntity.ok()
        .body("Successfully deleted");
  }
}
