package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.mapper.CreatedTrelloCard;
import com.crud.tasks.services.TrelloService;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("trello")
public class TrelloControler {

    @Autowired
    TrelloService trelloService;

    @GetMapping(value = "/")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloService.fetchTrelloBoards();
    }

    @PostMapping(value = "/")
    public CreatedTrelloCard createdTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloService.createdTrelloCard(trelloCardDto);
    }
}
