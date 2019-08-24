package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.services.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("tasks")
public class TaskController {

    @Autowired
    DbService dbService;

    @Autowired
    TaskMapper taskMapper;

    @GetMapping(value = "getTasks")
    public List<TaskDto> getTasks() {
        return taskMapper.mapToListTaskDto(dbService.getAllTasks());
    }

    @GetMapping(value = "/{id}")
    public TaskDto getTask(@PathVariable("id") long taskId) {
        return taskMapper.mapToTaskDto(dbService.getTaskById(taskId));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTask(@PathVariable("id") long taskId) {
    }

    @PutMapping(value = "/{id}")
    public TaskDto updateTask(@PathVariable("id") long taskId, @Valid TaskDto taskDto) {
        return new TaskDto(taskId, taskDto.getTitle(), taskDto.getContent());
    }

    @PostMapping(value = "/", consumes = APPLICATION_JSON_VALUE)
    public void createTask(@RequestBody TaskDto taskDto) {
        taskMapper.mapToTask(taskDto);
    }
}
