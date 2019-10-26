package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTestSuite {

    @InjectMocks
    TrelloMapper trelloMapper;

    @Test
    public void shouldMapTrelloBoardToTrelloBoardDto() {
        //Given
        TrelloList trelloList = new TrelloList("1","tmp",true);
        List<TrelloList> tmpTrelloList = new ArrayList<TrelloList>();
        tmpTrelloList.add(trelloList);
        TrelloBoard trelloBoard = new TrelloBoard("1","tmp",tmpTrelloList);
        List<TrelloBoard> tmpTrelloBoard = new ArrayList<>();
        tmpTrelloBoard.add(trelloBoard);
        //When
        List<TrelloBoardDto> listTrelloBoardDto = trelloMapper.mapToBoardsDto(tmpTrelloBoard);
        TrelloBoardDto trelloBoardDto = listTrelloBoardDto.get(0);
        //Then
        Assert.assertEquals(trelloBoardDto.getName(),"tmp");
    }

    @Test
    public void shouldMapTrelloBoardDtoToTrelloBoard() {
        //Given
        TrelloListDto trelloList = new TrelloListDto("1","tmp",true);
        List<TrelloListDto> tmpTrelloListDto = new ArrayList<TrelloListDto>();
        tmpTrelloListDto.add(trelloList);
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1","tmp",tmpTrelloListDto);
        List<TrelloBoardDto> tmpTrelloBoardDto = new ArrayList<>();
        tmpTrelloBoardDto.add(trelloBoardDto);
        //When
        List<TrelloBoard> listTrelloBoard = trelloMapper.mapToBoards(tmpTrelloBoardDto);
        TrelloBoard trelloBoard = listTrelloBoard.get(0);
        //Then
        Assert.assertEquals(trelloBoardDto.getName(),"tmp");
    }

    @Test

}
