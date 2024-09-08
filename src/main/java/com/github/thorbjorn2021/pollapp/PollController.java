package com.github.thorbjorn2021.pollapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/pollapp")
public class PollController {

    private final PollManager pollManager;
    private AtomicLong counter = new AtomicLong();

    public PollController(@Autowired PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try{
            pollManager.addUser(user);
            System.out.println("Creating user, " + user);
            return ResponseEntity.created(URI.create("/user/" + user.getUsername())).body(user);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }


    }

    @GetMapping("/users")
    public ResponseEntity<Map<String, User>> getAllUsers() {
        Map<String, User> users = pollManager.getUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/poll")
    public ResponseEntity<?> createPoll(@RequestBody Polldata polldata) {

        List<VoteOption> options = new ArrayList<>();
        for(int i = 0; i < polldata.getOptions().size(); i++){
            String caption = polldata.getOptions().get(i);
            options.add(new VoteOption(caption, i+1));
        }
        Poll poll = new Poll(
                polldata.getQuestion(),
                polldata.getDuration(),
                polldata.getUser(),
                polldata.isPrivate()
                ,
                options
        );
        //Checking to see if user exist
        User user = poll.getCreator();
        if(pollManager.getUsers().containsKey(user.getUsername())){
            poll.setId(String.valueOf(counter.incrementAndGet()));
            pollManager.addPoll(poll.getId(), poll);
            return ResponseEntity.created(URI.create("/poll/" + poll.getId())).body(poll);
        }
        else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User " + user.getUsername() + " does not exist");
        }
    }

    @GetMapping("/polls")
    public ResponseEntity<Map<String, Poll>> getAllPolls() {
        Map<String, Poll> polls = pollManager.getPolls();
        return ResponseEntity.ok(polls);
    }
}
