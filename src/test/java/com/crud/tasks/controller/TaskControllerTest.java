package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TaskController taskController;

    @Test
    public void shouldFetchFirstTask() throws Exception {
        //Given
        when(taskController.getTask(1)).thenReturn(new TaskDto(1L, "Test title", "Test content"));
        //When & Given
        mockMvc.perform(get("/tasks/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.content", is("Test content")))
                .andExpect(jsonPath("$.title", is("Test title")));
    }

    @Test
    public void shouldFetchAllTasks() throws Exception {
        //Given
        List<TaskDto> taskLists = new ArrayList<>();
        taskLists.add(new TaskDto(1L, "Test title", "Test content"));
        taskLists.add(new TaskDto(2L, "Test title", "Test content"));
        when(taskController.getTasks()).thenReturn(taskLists);
        //When & Given
        mockMvc.perform(get("/tasks/").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void shouldCreateTask() throws Exception {
        //Given
        TaskDto taskDto = new TaskDto(
                1L,
                "Test title",
                "Test content"
        );
        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);
        when(taskController.createTask(any(TaskDto.class))).thenReturn(taskDto);
        //When & Then
        mockMvc.perform(post("/tasks/")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Test title")))
                .andExpect(jsonPath("$.content", is("Test content")));
    }

}