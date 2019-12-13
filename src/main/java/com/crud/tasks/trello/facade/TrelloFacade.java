package com.crud.tasks.trello.facade;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.mapper.CreatedTrelloCardDto;
import com.crud.tasks.mapper.TrelloMapper;
import com.crud.tasks.services.TrelloService;
import com.crud.tasks.trello.validiator.TrelloValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TrelloFacade {

    private final TrelloService trelloService;
    private final TrelloMapper trelloMapper;
    private final TrelloValidator trelloValidator;

    @Autowired
    public TrelloFacade(TrelloService trelloService, TrelloMapper trelloMapper, TrelloValidator trelloValidator) {
        this.trelloService = trelloService;
        this.trelloMapper = trelloMapper;
        this.trelloValidator = trelloValidator;
    }

    public List<TrelloBoardDto> fetchTrelloBoards() {
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloService.fetchTrelloBoards());
        List<TrelloBoard> filteredBoards = trelloValidator.validateTrelloBoards(trelloBoards);
        return trelloMapper.mapToBoardsDto(filteredBoards);

    }

    public CreatedTrelloCardDto createCard(final TrelloCardDto trelloCardDto){
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        trelloValidator.validateCard(trelloCard);
        return trelloService.createdTrelloCard(trelloMapper.mapToCardDto(trelloCard));
    }
}
