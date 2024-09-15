//import pollData from "../mock/mockdata.js";
import {useState} from "react";


export default function VoteComponent({pollData}){
    //const [pollData, setPollData] = useState(poll)

    const handleVote = (id, answer) =>{
        console.log(`Vote with id:${id}, answer:${answer}`)
    };

    if(!pollData){
        return <div>Loading poll...</div>
    }

    return (
        <div >
            <h1 style={{color: "#2779ff"}}>{`Poll#${pollData.pollId} - ${pollData.question}`}</h1>
            {pollData.voteOptions.map((voteOption) => (
                <div className="voteOption" key={voteOption.id}>
                    <h2>{voteOption.optionText}</h2>
                    <button className="button button-upvote" onClick={() => handleVote(voteOption.id, 'upvote')}>UpVote</button>
                    <button className="button button-downvote" onClick={() => handleVote(voteOption.id, 'downvote')}>DownVote</button>
                    <p style={{color: "#2779ff"}} >{voteOption.voteCount} votes</p>
                </div>
            ))}
        </div>
    )
}