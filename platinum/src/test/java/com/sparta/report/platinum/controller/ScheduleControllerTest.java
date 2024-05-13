package com.sparta.report.platinum.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.report.platinum.dto.ScheduleCreateRequest;
import com.sparta.report.platinum.dto.ScheduleDeleteRequest;
import com.sparta.report.platinum.dto.ScheduleResponse;
import com.sparta.report.platinum.dto.ScheduleUpdateRequest;
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

  private final String baseUrl = "/schedule";

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
    mvc.perform(get(baseUrl))
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
  void createTest() throws Exception {
    // given
    ScheduleCreateRequest request = new ScheduleCreateRequest("123", "123", "456", "789@gmail.com");
    ScheduleResponse response = new ScheduleResponse(1L, "123", "456", "789@gmail.com", LocalDateTime.now());

    // when
    when(service.save(any())).thenReturn(response);

    // then
    mvc.perform(post(baseUrl)
            .content(objectMapper.writeValueAsString(request))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpectAll(status().isCreated(),
            content().contentType(MediaType.APPLICATION_JSON),
            jsonPath("$.id").exists(),
            jsonPath("$.title").exists(),
            jsonPath("$.description").exists(),
            jsonPath("$.username").exists(),
            jsonPath("$.createdAt").exists());
  }

  @Test
  void updateTest() throws Exception {
    // given
    ScheduleUpdateRequest request = new ScheduleUpdateRequest(1L, "123", "123");
    ScheduleResponse response = new ScheduleResponse(1L, "123", "456", "789@gmail.com", LocalDateTime.now());

    // when
    when(service.update(any())).thenReturn(response);

    // then
    mvc.perform(put(baseUrl)
            .content(objectMapper.writeValueAsString(request))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpectAll(status().isOk(),
            content().contentType(MediaType.APPLICATION_JSON),
            jsonPath("$.id").exists(),
            jsonPath("$.title").exists(),
            jsonPath("$.description").exists(),
            jsonPath("$.username").exists(),
            jsonPath("$.createdAt").exists());
  }

  @Test
  void deleteTest() throws Exception {
    ScheduleDeleteRequest request = new ScheduleDeleteRequest(1L, "123");

    // then
    mvc.perform(delete(baseUrl)
            .content(objectMapper.writeValueAsString(request))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpectAll(status().isOk()
        );
  }
}