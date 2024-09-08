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

    public void addPoll(String id, Poll poll) {
        polls.put(id, poll);
    }

    public Map<String, Poll> getPolls() {
        return polls;
    }

}
