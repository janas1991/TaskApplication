package com.crud.tasks.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TrelloConfig {
    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndPoint;

    @Value("${trello.app.key}")
    private String trelloAppKey;

    @Value("${trello.app.token}")
    private String trelloToken;

    @Value("${trello.app.username}")
    private String trelloUsername;

    public String getTrelloApiEndPoint() {
        return trelloApiEndPoint;
    }

    public String getTrelloAppKey() {
        return trelloAppKey;
    }

    public String getTrelloToken() {
        return trelloToken;
    }

    public String getTrelloUsername() {
        return trelloUsername;
    }
}
