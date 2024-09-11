package com.github.thorbjorn2021.pollapp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String email;
    @JsonIgnore
    private List<Poll> createdPolls;
    @JsonIgnore
    private List<Vote> votes;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.createdPolls = new ArrayList<Poll>();
        this.votes = new ArrayList<Vote>();
    }

    public List<Poll> getCreatedPolls() {
        return createdPolls;
    }

    public void addPoll(Poll poll) {
        if(!createdPolls.contains(poll)) {
            createdPolls.add(poll);
        }
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void addVote(Vote vote) {
        votes.add(vote);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}
