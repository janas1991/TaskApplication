package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/TaskController")
public class TaskController {

    @GetMapping(value = "/getTasks")
    public List<TaskDto> getTasks() {
        return new ArrayList<TaskDto>();
    }

    @GetMapping(value = "/getTask")
    public TaskDto getTask(long taskId) {
        return new TaskDto(taskId, "test_title", "test_content");
    }

    @DeleteMapping(value = "/delateTask")
    public void delateTask(long taskId) {

    }

    @PutMapping(value = "/updateTask")
    public TaskDto updateTask(TaskDto taskDto) {
        return new TaskDto(1L, "test_title", "test_content");
    }

    @PostMapping(value = "/createTask")
    public void createTask(TaskDto taskDto) {

    }
}
