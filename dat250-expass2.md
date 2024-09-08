
# Report on the work done with the backend of the Poll application so far.

## Technical problems
Installation went smooth, except for installing WSL. I could not install WSL by following the tutorial, but troubleshooting this problem lead me to download WSL from Microsoft Store instead. This proved to be the solution.
## Key features implemented
I followed the assignment step by step. I implemented the classes from the domain model, Poll, User, Vote and VoteOption. Due to difficulties interpreting and implementing the relations between the domain objects, these had to be refactored a couple of times. I wrote several tests and used Bruno to test the api with these tests. 

Following a test-driven approach I used the tests written in Bruno to implement the handlers. I also made use of @JsonIgnore, @JsonManagedReference and JsonBackReference to avoid cycles.

So far, what seems to be working is:
- Creating user
- listing users
- creating poll
- list polls
## Pending issues
Finishing step 4 and step 5-7.

## Link to code written in this assignment
[Link](https://github.com/Thorbjorn2021/poll-app-backend/tree/main/src/main/java/com/github/thorbjorn2021/pollapp)
