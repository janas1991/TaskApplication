package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloBoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Component
public class TrelloClient {

    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndPoint;

    @Value("${trello.app.key}")
    private String trelloAppKey;

    @Value("${trello.app.token}")
    private String trelloToken;

    @Value("${trello.app.username}")
    private String trelloUsername;

    @Autowired
    RestTemplate restTemplate;

    public List<Optional<TrelloBoardDto[]>> getTrelloBoards() {

        TrelloBoardDto[] boardsResponse = restTemplate.getForObject(getURIToTrello(trelloAppKey, trelloToken, trelloApiEndPoint, trelloUsername), TrelloBoardDto[].class);
        try {
            return Arrays.asList(ofNullable(boardsResponse));
        } catch (RestClientResponseException e) {
            throw new RestClientResponseException(e.getMessage(), e.getRawStatusCode(), e.getStatusText(), e.getResponseHeaders(), e.getResponseBodyAsByteArray(), Charset.defaultCharset());
        }
    }

    private URI getURIToTrello(String trelloAppKey, String trelloToken, String trelloApiEndPoint, String
            trelloUsername) {

        URI url = UriComponentsBuilder.fromHttpUrl(trelloApiEndPoint + "/members/" + trelloUsername + "/boards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("fields", "name,id")
                .queryParam("lists", "all").build().encode().toUri();

        return url;
    }
}
