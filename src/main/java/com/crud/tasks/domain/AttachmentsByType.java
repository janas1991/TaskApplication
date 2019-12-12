package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AttachmentsByType {

    public AttachmentsByType(Trello trello) {
        this.trello = trello;
    }

    public AttachmentsByType() {
    }

    public Trello getTrello() {
        return trello;
    }

    @JsonProperty("trello")
    private Trello trello;
}
