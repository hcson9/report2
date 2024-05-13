package com.sparta.report.platinum.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * create on 2024/05/13 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileDownloadRequest {

  /**
   * 파일 경로.
   */
  private String path;

  /**
   * 생성자.
   *
   * @param path 파일 경로
   */
  public FileDownloadRequest(String path) {
    this.path = path;
  }
}
