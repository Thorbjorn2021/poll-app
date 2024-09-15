import '../style.css'
import {useState} from "react";
import pollData from "../mock/mockdata.js";

function CreatePollComponent() {
    const [question, setQuestion] = useState('');
    const [options, setOptions] = useState(['']);

    const addOption = () => setOptions([...options, '']);
    const removeOption = (index) => setOptions(options.filter((_, i) => i !== index));

    const handleOptionChange = (e, index) => {
        const newOptions = options.slice();
        newOptions[index] = e.target.value;
        setOptions(newOptions);
    };
    const handleSubmit = (e) => {
        e.preventDefault();
        console.log('Poll Question:', question);
        console.log('Poll Options:', options);
        const pollData = {
            question,
            options: options
        }
        console.log(pollData)
        createPoll(pollData)
    };

    const createPoll = (pollData) => {
        fetch("http://localhost:8080/pollapp/poll", {
            method:"POST",
            headers: {
                "Content-Type" :"application/json"
            },
            body: JSON.stringify(pollData)
        })
            .then((response) => {
                if(!response.ok){
                    throw new Error("Error, did not create Poll!")
                }
                return response.json()
            })
            .then((data) => {
                console.log("Succesfully created Poll: ", data)
            })
            .catch((error) => {
                console.error("Error: ", error)
                alert("Error when creating the poll!")
            })

    }

    return (
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                placeholder="Enter poll question"
                value={question}
                onChange={(e) => setQuestion(e.target.value)}
            />
            {options.map((option, index) => (
                <div key={index}>
                    <input
                        type="text"
                        placeholder={`Option ${index + 1}`}
                        value={option}
                        onChange={(e) => handleOptionChange(e, index)}
                    />
                    <button type="button" onClick={() => removeOption(index)}>
                        Remove
                    </button>
                </div>
            ))}
            <button type="button" onClick={addOption}>
                Add Option
            </button>
            <button type="submit">Create Poll</button>
        </form>
    );
}

export default CreatePollComponent;