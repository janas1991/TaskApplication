package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        List<TaskDto> tmpList = getTasks();
        TaskDto tmpTaskDto = null;
        for (TaskDto taskDto : tmpList) {
            if (taskDto.getId() == taskId) {
                tmpTaskDto = new TaskDto(taskDto.getId(), taskDto.getTitle(), taskDto.getContent());
                return tmpTaskDto;
            } else {
                return null;
            }
        }
        return tmpTaskDto;
    }

    @DeleteMapping(value = "task/{id}")
    public void deleteTask(@PathVariable("id") long taskId) {
    }

    @PutMapping(value = "task/{id}")
    public TaskDto updateTask(@PathVariable("id") long taskId, @Valid TaskDto taskDto) {
        return new TaskDto(taskId, taskDto.getTitle(), taskDto.getContent());
    }

    @PostMapping(value = "task/{id},{title},{content}")
    public Task createTask(@PathVariable("id") long taskId, @PathVariable("title") String title, @PathVariable("content") String content) {
        return new Task(taskId, title, content);
    }
}
