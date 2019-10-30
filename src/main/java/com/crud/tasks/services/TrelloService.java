package com.crud.tasks.services;

import com.crud.tasks.domain.Mail;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.mapper.CreatedTrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import static java.util.Optional.ofNullable;

@Service
public class TrelloService {

   // @Autowired
    //AdminConfig adminConfig;
    @Autowired
    TrelloClient trelloClient;
    @Autowired
    SimpleEmailService emailService;

    private static final String SUBJECT = "Tasks: New Trello Card";

    public List<TrelloBoardDto> fetchTrelloBoards() {
        return trelloClient.getTrelloBoards();
    }

    public CreatedTrelloCardDto createdTrelloCard(final TrelloCardDto trelloCardDto){
        CreatedTrelloCardDto newCard = trelloClient.createNewCard(trelloCardDto);
        ofNullable(newCard).ifPresent(card->emailService.send(new Mail("michaljanas1991@gmail.com",SUBJECT,"New Card" + card.getName() + "has been created on your Trello account","michaljanas1991@gmail.com")));
        return newCard;
    }
}
