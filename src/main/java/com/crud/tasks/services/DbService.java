package com.crud.tasks.services;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class DbService {

    private TaskRepository taskRepository;

    public DbService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(final long id) {
        return taskRepository.findById(id);
    }

    public Task saveTask(final Task task) {
        return taskRepository.save(task);
    }

    public void deleteTaskById(final long id) {
        taskRepository.deleteById(id);
    }
}
