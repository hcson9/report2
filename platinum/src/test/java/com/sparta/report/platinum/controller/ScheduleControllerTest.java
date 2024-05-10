package com.sparta.report.platinum.controller;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.report.platinum.dto.ScheduleResponse;
import com.sparta.report.platinum.service.ScheduleService;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/**
 * create on 2024/05/10 create by IntelliJ IDEA.
 *
 * <p> New Project. </p>
 *
 * @author HoChan Son (hcson)
 * @version 1.0
 * @since 1.0
 */
@WebMvcTest(ScheduleController.class)
class ScheduleControllerTest {

  @Autowired
  private MockMvc mvc;


  @Autowired
  private ObjectMapper objectMapper;

  @MockBean
  private ScheduleService service;

  private String baseUrl = "/schedule";

  @Test
  void findByIdTest() throws Exception {
    //given
    ScheduleResponse response = new ScheduleResponse(1L, "123", "456", "789", LocalDateTime.now());

    // when
    when(service.findById(anyLong())).thenReturn(response);

    // then
    mvc.perform(get(baseUrl + "/{id}", 1))
        .andExpectAll(status().isOk(),
            content().contentType(MediaType.APPLICATION_JSON),
            jsonPath("$.id").exists(),
            jsonPath("$.title").exists(),
            jsonPath("$.description").exists(),
            jsonPath("$.username").exists(),
            jsonPath("$.createdAt").exists()
        );
  }

  @Test
  void findAllTest() throws Exception {
    //given
    ScheduleResponse response = new ScheduleResponse(1L, "123", "456", "789", LocalDateTime.now());

    // when
    when(service.findAll()).thenReturn(List.of(response));

    // then
    mvc.perform(get(baseUrl ))
        .andExpectAll(status().isOk(),
            content().contentType(MediaType.APPLICATION_JSON),
            jsonPath("$[0].id").exists(),
            jsonPath("$[0].title").exists(),
            jsonPath("$[0].description").exists(),
            jsonPath("$[0].username").exists(),
            jsonPath("$[0].createdAt").exists()
        );
  }

  @Test
  void createTest() {
  }

  @Test
  void updateTest() {
  }

  @Test
  void deleteTest() {
  }
}