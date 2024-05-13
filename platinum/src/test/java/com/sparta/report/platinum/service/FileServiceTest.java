package com.sparta.report.platinum.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
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
class FileServiceTest {

  private FileService fileService = new FileService();

  @Test
  void downloadTest() throws IOException {
    // then
    assertNotNull(fileService.download("123"));
  }

  @Test
  void saveTest() throws IOException {
    // given
    MultipartFile file = Mockito.mock(MultipartFile.class);
    String name = "123";
    given(file.getOriginalFilename()).willReturn(name);


    // then
    assertThat(fileService.save(file)).isEqualTo(name);
  }
}