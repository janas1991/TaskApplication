package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.services.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {

    @Autowired
    DbService dbService;

    @Autowired
    TaskMapper taskMapper;

    @GetMapping(value = "")
    public List<TaskDto> getTasks() {
        return taskMapper.mapToListTaskDto(dbService.getAllTasks());
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

    @DeleteMapping(value = "/{id}")
    public void deleteTask(@PathVariable("id") long taskId) {
    }

    @PutMapping(value = "/{id}")
    public TaskDto updateTask(@PathVariable("id") long taskId, @Valid TaskDto taskDto) {
        return new TaskDto(taskId, taskDto.getTitle(), taskDto.getContent());
    }

    @PostMapping(value = "/{id}")
    public Task createTask(@PathVariable("id") long taskId, String title, String content) {
        return new Task(taskId, title, content);
    }
}
