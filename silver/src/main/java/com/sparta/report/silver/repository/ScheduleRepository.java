package com.sparta.report.silver.repository;

import com.sparta.report.silver.exception.DataNotFoundException;
import com.sparta.report.silver.model.Schedule;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

/**
 * create on 2024/05/10 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
@Repository
public class ScheduleRepository {

  private static final AtomicLong ID = new AtomicLong(1);

  private static final Map<Long, Schedule> db = new ConcurrentHashMap<>();

  /**
   * Auto Increment 대체.
   *
   * @return id.
   */
  public static synchronized long getNextId() {
    return ID.getAndIncrement();
  }

  /**
   * id 로 일정찾기.
   *
   * @param id id
   * @return 조회된 스케쥴
   * @throws DataNotFoundException 데이터가 없을 시 발생.
   */
  public Schedule findById(long id) throws DataNotFoundException {
    checkId(id);
    return db.get(id);
  }

  /**
   * 저장.
   *
   * @param schedule 저장할 일정.
   * @return 저장된 정보
   */
  public Schedule save(Schedule schedule) {
    db.put(schedule.getId(), schedule);
    return db.get(schedule.getId());
  }

  /**
   * 전체 일정 확인.
   *
   * @return 일정 리스트
   */
  public List<Schedule> findAll() {
    return db.values().stream().toList();
  }

  /**
   * 일정 수정.
   *
   * @param schedule 수정할 스케쥴
   * @return 수정 된 객체.
   * @throws DataNotFoundException 데이터 없을 시 발생
   */
  public Schedule update(Schedule schedule) throws DataNotFoundException {
    checkId(schedule.getId());
    return db.putIfAbsent(schedule.getId(), schedule);
  }

  /**
   * 삭제 요청.
   *
   * @param id 삭제할 id
   * @throws DataNotFoundException 값이 없을 시 발생
   */
  public void delete(long id) throws DataNotFoundException {
    checkId(id);
    db.remove(id);
  }

  /**
   * db 에 Id 가 있는지 체크.
   *
   * @param id 체크할 id
   */
  private void checkId(long id) {
    if (!db.containsKey(id)) {
      throw new DataNotFoundException(id + " does not exist");
    }
  }
}
