package com.github.thorbjorn2021.pollapp;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Component
public class PollManager {

    private Map<String, User> users = new HashMap<String, User>();
    private Map<String, Poll> polls = new HashMap<String, Poll>();

    public PollManager() {
    }

    public void addUser(String userName, String email) {
        if(users.containsKey(userName)) {
            throw new IllegalArgumentException("Username is already in use");
        }
        User user = new User(userName, email);
        users.put(userName, user);
    }

    public void listUsers() {
        for(User user : users.values()) {
            System.out.println(user);
        }
    }

    public void addPoll(String question, Instant publishedAt, Instant validUntil, String poll_id) {
        if(polls.containsKey(poll_id)) {
        throw new IllegalArgumentException("Duplicate poll-id!");
    }
        Poll poll = new Poll(question, publishedAt, validUntil);
        polls.put(poll_id, poll);

    }



}
