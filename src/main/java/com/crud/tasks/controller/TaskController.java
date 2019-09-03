package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.services.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("tasks")
public class TaskController {

    @Autowired
    DbService dbService;

    @Autowired
    TaskMapper taskMapper;

    @GetMapping(value = "/")
    public List<TaskDto> getTasks() {
        return taskMapper.mapToListTaskDto(dbService.getAllTasks());
    }

    @GetMapping(value = "/{id}")
    public TaskDto getTask(@PathVariable("id") long taskId) throws TaskNotFoundException {
        return taskMapper.mapToTaskDto(dbService.getTaskById(taskId).orElseThrow(TaskNotFoundException::new));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTask(@PathVariable("id") long taskId) {
        dbService.deleteTaskById(taskId);
    }

    @PutMapping(value = "/")
    public TaskDto updateTask(@RequestBody TaskDto taskDto) {
        return taskMapper.mapToTaskDto(dbService.saveTask(taskMapper.mapToTask(taskDto)));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createTask(@RequestBody TaskDto taskDto) {
        dbService.saveTask(taskMapper.mapToTask(taskDto));
    }
}
