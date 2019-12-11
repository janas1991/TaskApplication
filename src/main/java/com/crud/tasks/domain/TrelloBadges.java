package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloBadges {

    public TrelloBadges(int votes, AttachmentsByType attachmentsByType) {
        this.votes = votes;
        this.attachmentsByType = attachmentsByType;
    }

    public TrelloBadges() {
    }

    public int getVotes() {
        return votes;
    }

    public AttachmentsByType getAttachmentsByType() {
        return attachmentsByType;
    }

    @JsonProperty("votes")
    private int votes;

    @JsonProperty("attachmentsByType")
    private AttachmentsByType attachmentsByType;
}
