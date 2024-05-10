package com.sparta.report.platinum.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
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

  @PostMapping(value = "",
      consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  ResponseEntity<List<String>> upload(
      @RequestPart("files") MultipartFile[] files) {

    List<String> imageFileNames = new ArrayList<>();

    for (MultipartFile file : files) {
      if (file.getContentType() != null
          && file.getContentType().startsWith("image/")) {
        try {
          // 이미지 파일인 경우 임시 디렉토리에 저장
          // 이하 생략
          imageFileNames.add(file.getOriginalFilename());
        } catch (Exception e) {
          e.printStackTrace();
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
      }
    }

    return ResponseEntity.ok().body(imageFileNames);
  }

//  @PostMapping(value = "/excel-download",
//      produces = MediaType.APPLICATION_JSON_VALUE)
//
//  public ResponseEntity<byte[]> download() throws IOException {
////    DownLoadResponse response = service.downloadFileByRequestId(request);
//
//    // 다운로드할 파일의 MIME 타입 설정 xlsx
//    String contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
//
//    File file = null;
//    // Response Headers 설정
//    HttpHeaders headers = new HttpHeaders();
//    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName());
//    headers.add(HttpHeaders.CONTENT_TYPE, contentType);
//
//    return ResponseEntity.ok()
//        .headers(headers)
//        .contentLength(file.length())
//        .body(readBytesFromFile(file));
//  }

}
