package com.crud.tasks.domain;

public class TrelloCardDto {
    private String name;
    private String description;
    private String pos;
    private String listId;

    public TrelloCardDto(String name, String description, String pos, String listId) {
        this.name = name;
        this.description = description;
        this.pos = pos;
        this.listId = listId;
    }

    public TrelloCardDto() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPos() {
        return pos;
    }

    public String getListId() {
        return listId;
    }
}
