package com.sparta.report.platinum.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.report.platinum.dto.FileDownloadRequest;
import com.sparta.report.platinum.service.FileService;
import com.sparta.report.platinum.service.ScheduleService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.ResourceUtils;
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
@WebMvcTest(FileController.class)
class FileControllerTest {

  @Autowired
  private MockMvc mvc;


  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private FileService service;

  private final String baseUrl = "/file";

  @Test
  void uploadTest() throws Exception {
    // Given
    MockMultipartFile file1 = new MockMultipartFile("files", "1.png", "image/png",
        "image1".getBytes());
    MockMultipartFile file2 = new MockMultipartFile("files", "2.png", "image/png",
        "image2".getBytes());

    // When
    mvc.perform(multipart(baseUrl + "/upload")
            .file(file1)
            .file(file2))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$.length()").value(2));
  }


  @Test
  void downloadTest() throws Exception {
    FileDownloadRequest request = new FileDownloadRequest("123");
    File file = readFile();

    when(service.download(anyString())).thenReturn(file);

    mvc.perform(post(baseUrl + "/download")
            .content(objectMapper.writeValueAsBytes(request))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpectAll(status().isOk(),
            content().contentType(MediaType.IMAGE_PNG));
  }

  private File readFile() throws FileNotFoundException {
    File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "2.png");
    return file;
  }
}