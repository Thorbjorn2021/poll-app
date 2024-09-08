package com.github.thorbjorn2021.pollapp;

import java.time.Instant;

public class Vote {
    private Instant publishedAt;
    private Poll poll;
    private User user;
    private VoteOption voteOption;

    public Vote(Instant publishedAt, Poll poll, User user, VoteOption voteOption) {
        this.publishedAt = publishedAt;
        this.poll = poll;
        this.user = user;
        this.voteOption = voteOption;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public VoteOption getVoteOption() {
        return voteOption;
    }

    public void setVoteOption(VoteOption voteOption) {
        this.voteOption = voteOption;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }
}
