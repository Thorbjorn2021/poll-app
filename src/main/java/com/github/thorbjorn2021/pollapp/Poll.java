package com.github.thorbjorn2021.pollapp;

import java.time.Instant;
import java.util.List;

public class Poll {
    private String question;
    private Instant publishedAt;
    private Instant validUntil;
    private List<VoteOption> options;
    private User creator;
    private boolean isPrivate;
    private String id;

    public Poll(String question,Instant publishedAt, Instant validUntil, User creator, boolean isPrivate, List<VoteOption> options) {
        this.question = question;
        this.publishedAt = publishedAt;
        this.validUntil = validUntil;
        this.creator = creator;
        this.isPrivate = isPrivate;
        this.options = options;
    }
    public Poll(String question, long durationSec, User creator, boolean isPrivate, List<VoteOption> options) {
        this.question = question;
        this.publishedAt = Instant.now();
        this.validUntil = Instant.now().plusSeconds(durationSec);
        this.creator = creator;
        this.isPrivate = isPrivate;
        this.options = options;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Instant getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Instant validUntil) {
        this.validUntil = validUntil;
    }

    public List<VoteOption> getOptions() {
        return options;
    }

    public void setOptions(List<VoteOption> options) {
        this.options = options;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public void setId(String id){
        this.id = id;
    }
    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return question + " with options " + options + " by user " + creator;
    }
}
