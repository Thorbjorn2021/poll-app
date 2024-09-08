package com.github.thorbjorn2021.pollapp;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Component
public class PollManager {

    private final Map<String, User> users = new HashMap<String, User>();
    private final Map<String, Poll> polls = new HashMap<String, Poll>();

    public PollManager() {
    }

    public void addUser(User user) {
        if(users.containsKey(user.getUsername())) {
            throw new IllegalArgumentException("Username is already in use");
        }
        users.put(user.getUsername(), user);
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void addPoll(String question, Instant publishedAt, Instant validUntil) {
        String poll_id = String.valueOf(polls.size());
        if(polls.containsKey(poll_id)) {
        throw new IllegalArgumentException("Duplicate poll-id!");
    }
        Poll poll = new Poll(question, publishedAt, validUntil);
        polls.put(poll_id, poll);

    }



}
