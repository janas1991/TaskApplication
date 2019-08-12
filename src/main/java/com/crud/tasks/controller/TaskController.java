package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    private List<TaskDto> getTasks() {
        return new ArrayList<TaskDto>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTask")
    private TaskDto getTask(long taskId) {
        return new TaskDto(taskId, "test_title", "test_content");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delateTask")
    private void delateTask(long taskId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
    private TaskDto updateTask(TaskDto taskDto) {
        return new TaskDto(1L, "test_title", "test_content");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTask")
    private void createTask(TaskDto taskDto) {

    }
}
