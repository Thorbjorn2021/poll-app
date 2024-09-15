import CreateUserComponent from "./components/CreateUserComponent.jsx";
import {useState} from "react";
import CreatePollComponent from "./components/CreatePollComponent.jsx";
import VoteComponent from "./components/VoteComponent.jsx";

function App(){
    const [user, setUser] = useState(null);
    const [polldata, setPolldata] = useState( {
        pollId: 1,
        question: "What is your favorite programming language?",
        voteOptions: [
            {
                id: 1,
                optionText: "JavaScript",
                voteCount: 25
            },
            {
                id: 2,
                optionText: "Python",
                voteCount: 35
            },
            {
                id: 3,
                optionText: "Java",
                voteCount: 15
            },
            {
                id: 4,
                optionText: "C++",
                voteCount: 5
            }
        ]
    })


    const handleUserCreation = (userData) => {
        setUser(userData);
    };

    return(
        <div className="container-main">
            <CreateUserComponent onUserCreate={handleUserCreation} user={user}></CreateUserComponent>
            <CreatePollComponent></CreatePollComponent>
            <VoteComponent pollData={polldata}></VoteComponent>
        </div>
    )
}

export default App;