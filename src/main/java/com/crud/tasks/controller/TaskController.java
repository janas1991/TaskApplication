package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/TaskController")
public class TaskController {

    @GetMapping(value = "/getTasks")
    public List<TaskDto> getTasks() {
        return new ArrayList<TaskDto>();
    }

    @GetMapping(value = "{id}")
    public TaskDto getTask(@PathVariable("id") long taskId) {
        return new TaskDto(taskId, "test_title", "test_content");
    }

    @DeleteMapping(value = "/delateTask/{id}")
    public void delateTask(@PathVariable("id") long taskId) {
    }

    @PutMapping(value = "/updateTask/{taskDto}")
    public TaskDto updateTask(@PathVariable("taskDto") TaskDto taskDto) {
        return new TaskDto(1L, "test_title", "test_content");
    }

    @PostMapping(value = "/createTask/{tasksDto}")
    public void createTask(@PathVariable("tasksDto") TaskDto taskDto) {

    }
}
