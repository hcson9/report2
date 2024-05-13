package com.sparta.report.platinum.controller;

import com.sparta.report.platinum.dto.FileDownloadRequest;
import com.sparta.report.platinum.service.FileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * create on 2024/05/10 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
@RestController
@RequestMapping("/file")
@Slf4j
@RequiredArgsConstructor
public class FileController {

  private final FileService fileService;

  /**
   * 파일 업로드.
   *
   * @param files 업로드할 file
   * @return 파일 경로
   */
  @PostMapping(value = "/upload",
      consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  @Operation(summary = "이미지 업로드", description = "이미지를 업로드합니다..")
  ResponseEntity<List<String>> upload(
      @Parameter(description = "업로드할 이미지 파일들", required = true)
      @RequestParam("files") MultipartFile[] files) {

    List<String> imageFileNames = new ArrayList<>();

    for (MultipartFile file : files) {
      if (file.getContentType() != null
          && file.getContentType().startsWith("image/")) {
        try {
          // 이미지 파일인 경우 임시 디렉토리에 저장
          // 이하 생략
          imageFileNames.add(fileService.save(file));
        } catch (Exception e) {
          log.error(e.getMessage());
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
      }
    }

    return ResponseEntity.ok().body(imageFileNames);
  }

  /**
   * 파일 다운로드.
   *
   * @param request 생성 요청
   * @return 파일
   * @throws IOException 파일 없을 시 발생
   */
  @PostMapping(value = "/download")
  @Operation(summary = "이미지 다운로드", description = "이미지를 다운로드합니다..")
  public ResponseEntity<byte[]> download(@RequestBody FileDownloadRequest request)
      throws IOException {
    File file = fileService.download(request.getPath());
    byte[] fileContent = Files.readAllBytes(file.toPath());

    // Response Headers 설정
    HttpHeaders headers = new HttpHeaders();
    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="
        + file.getName());
    headers.add(HttpHeaders.CONTENT_TYPE, Files.probeContentType(file.toPath()));

    return ResponseEntity.ok()
        .headers(headers)
        .contentLength(file.length())
        .body(fileContent);
  }
}
