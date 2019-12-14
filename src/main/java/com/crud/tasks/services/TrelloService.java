package com.crud.tasks.services;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.mapper.CreatedTrelloCardDto;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class TrelloService {

    private final TrelloClient trelloClient;
    private final SimpleEmailService simpleEmailService;
    private final AdminConfig adminConfig;
    private final TaskRepository taskRepository;

    @Autowired
    public TrelloService(TrelloClient trelloClient, SimpleEmailService simpleEmailService, AdminConfig adminConfig, TaskRepository taskRepository) {
        this.trelloClient = trelloClient;
        this.simpleEmailService = simpleEmailService;
        this.adminConfig = adminConfig;
        this.taskRepository = taskRepository;
    }

    private static final String SUBJECT = "Tasks: New Trello Card";


    public List<TrelloBoardDto> fetchTrelloBoards() {
        return trelloClient.getTrelloBoards();
    }

    public CreatedTrelloCardDto createdTrelloCard(final TrelloCardDto trelloCardDto){
        CreatedTrelloCardDto newCard = trelloClient.createNewCard(trelloCardDto);
        sendMail(newCard);
        return newCard;
    }

    @Scheduled(cron = "0 0 12 * * * " )
    public void sendDailyMessege(){
        simpleEmailService.send(simpleEmailService.createDailyMessage(new Mail(adminConfig.getAdminMail(),"task report","you got " + taskRepository.count() + " tasks to do","michaljanas1991@gmail.com")));
    }

    public void sendMail(CreatedTrelloCardDto createdTrelloCardDto){
        ofNullable(createdTrelloCardDto).ifPresent(card->simpleEmailService.send(simpleEmailService.createMimeMessage(new Mail(adminConfig.getAdminMail(),SUBJECT,"New card: " + card.getName() + " has been created on your Trello account","michaljanas1991@gmail.com"))));
    }
}
