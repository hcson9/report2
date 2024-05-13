package com.sparta.report.platinum.service;

import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * create on 2024/05/13 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
@Service
public class FileService {

  /**
   * 다운로드.
   *
   * @param filePath 파일 경로
   * @return 파일 정보
   * @throws IOException 파일 관련 Exception
   */
  public File download(String filePath) throws IOException {
    return new File(filePath);
  }

  /**
   * 저장.
   *
   * @param multipartFile 저장할 multi part
   * @return 경로
   * @throws IOException 파일 관련 Exception
   */
  public String save(MultipartFile multipartFile) throws IOException {
    return multipartFile.getOriginalFilename();
  }
}
