package com.crud.tasks.scheduler;

import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.services.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {
    private static final String SUBJECT = "Tasks: Once a day email";
    private static String taskCount;

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Scheduled(fixedDelay = 10000)
    public void sendInformationEmail() {
      //long size = taskRepository.count();
       // if (size == 1 || size == 0) {
      //      taskCount = "task";
       // } else {
       //     taskCount = "tasks";
       // }
        simpleEmailService.send(new Mail("michaljanas1991@gmail.com", SUBJECT, "Currently in database you got: ", "michaljanas1991@gmail.com"));
    }

}
