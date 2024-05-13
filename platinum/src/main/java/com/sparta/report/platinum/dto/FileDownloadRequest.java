package com.sparta.report.platinum.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
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
@Schema(name = "file download request", description = "파일 다운로드 요청")
public class FileDownloadRequest {

  /**
   * 파일 경로.
   */
  @NotNull
  @Schema(name = "path", description = "파일경로", example = "1.png")
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
