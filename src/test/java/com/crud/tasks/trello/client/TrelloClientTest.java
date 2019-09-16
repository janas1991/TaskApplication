package com.crud.tasks.trello.client;

import com.crud.tasks.config.TrelloConfig;
import com.crud.tasks.domain.TrelloBadges;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.mapper.CreatedTrelloCard;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloClientTest {

    @InjectMocks
    private TrelloClient trelloClient;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private TrelloConfig trelloConfig;

    @Mock
    TrelloBadges trelloBadges;

    @Before
    public void init() {
        //Given
        when(trelloConfig.getTrelloApiEndPoint()).thenReturn("http://test.com");
        when(trelloConfig.getTrelloAppKey()).thenReturn("test");
        when(trelloConfig.getTrelloToken()).thenReturn("test");
    }

    @Test
    public void shouldFetchTrelloBoards() throws URISyntaxException {

        TrelloBoardDto[] trelloBoards = new TrelloBoardDto[1];
        trelloBoards[0] = new TrelloBoardDto("test_board", "test_id", new ArrayList<>());

        URI url = new URI("http://test.com/members/michajanas2/boards?key=test&token=test&fields=name,id&lists=all");

        when(restTemplate.getForObject(url, TrelloBoardDto[].class)).thenReturn(trelloBoards);
        //when
        List<TrelloBoardDto> fetchedTrelloBoards = trelloClient.getTrelloBoards();
        //Then
        assertEquals(1, fetchedTrelloBoards.size());
        assertEquals("test_id", fetchedTrelloBoards.get(0).getId());
    }

    @Test
    public void shouldReturnEmptyList() throws URISyntaxException{
        //GIVEN
        TrelloBoardDto[] trelloBoards = new TrelloBoardDto[1];
        trelloBoards[0] = new TrelloBoardDto();
        URI uri = new URI("http://test.com/members/michajanas2/boards?key=test&token=test&fields=name,id&lists=all");
        when(restTemplate.postForObject(uri,null,TrelloBoardDto[].class)).thenReturn(trelloBoards);
        //WHEN
        List<TrelloBoardDto> emptyTrelloBoards = trelloClient.getTrelloBoards();
        //THEN
        assertEquals(emptyTrelloBoards.size(),0);
    }


}