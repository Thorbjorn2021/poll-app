package com.github.thorbjorn2021.pollapp;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PollManager {
    public Map<Long, User> users = new HashMap<Long, User>();
    public Map<Long, Poll> polls = new HashMap<Long, Poll>();

    public PollManager() {
    }
}
