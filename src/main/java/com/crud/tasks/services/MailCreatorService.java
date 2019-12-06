package com.crud.tasks.services;


import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@Service
public class MailCreatorService {

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private TaskRepository taskRepository;

    public String buildTrelloCardEmail(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8080/tasks/");
        context.setVariable("button", "Visit website");
        context.setVariable("goodbye", "Best Regards");
        context.setVariable("preview_message", "New Task");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("admin_company", adminConfig.getAdminCompany());
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String bulidInfromationMail(String message) {
        Context context = new Context();
        context.setVariable("message",message);
        context.setVariable("tasks_url", "http://localhost:8080/tasks/");
        context.setVariable("button", "Visit website");
        context.setVariable("goodbye", "Best Regards");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("admin_company", adminConfig.getAdminCompany());
        return templateEngine.process("mail/created-information-mail", context);
    }
}