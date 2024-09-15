//import pollData from "../mock/mockdata.js";
import {useEffect, useState} from "react";


export default function VoteComponent() {
    const [pollData, setPollData] = useState()

    useEffect(() => {
        fetch("http://localhost:8080/pollapp/polls")
    .then((response) => {
        if (!response.ok) {
            throw new Error("Poll not found!")
        }
        return response.json()
    })
        .then((data) => {
            setPollData(data)
            console.log(data)
        })
        .catch((error) => {
            console.error("Error - did not succeed fetching polldata:", error)
            alert("Failed loading poll data")
        })
    }, [])

    const handleVote = (id, answer) =>{
        console.log(`Vote with id:${id}, answer:${answer}`)
    };

    if(!pollData || Object.keys(pollData).length === 0){
        return <div>Loading poll...</div>
    }

    return (
        <div >
            <h1 style={{color: "#2779ff"}}>{`Poll#${pollData[0].id} - ${pollData[0].question}`}</h1>
            {pollData[0].options.map((voteOption) => (
                <div className="voteOption">
                    <h2>{voteOption.caption}</h2>
                    <button className="button button-upvote" onClick={() => handleVote(voteOption.id, 'upvote')}>UpVote</button>
                    <button className="button button-downvote" onClick={() => handleVote(voteOption.id, 'downvote')}>DownVote</button>
                    <p style={{color: "#2779ff"}} >{voteOption.votes} votes</p>
                </div>
            ))}
        </div>
    )
}