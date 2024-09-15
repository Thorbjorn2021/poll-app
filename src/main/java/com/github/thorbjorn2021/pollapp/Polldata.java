package com.github.thorbjorn2021.pollapp;

import java.util.List;

public class Polldata {
    private String question;
    private long duration;
    private User user;
    private boolean isPrivate;
    private List<String> options;

    public Polldata(String question, long duration, User user, boolean isPrivate, List<String> options) {
        this.question = question;
        this.duration = duration;
        this.user = user;
        this.isPrivate = isPrivate;
        this.options = options;
    }

    public Polldata(String question, List<String> options) {
        this.question = question;
        this.options = options;
    }

    public Polldata(){}

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
