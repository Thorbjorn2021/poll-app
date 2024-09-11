import {useState} from "react";

export default function CreateUserComponent({onUserCreate, user}){
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");

    const handleSubmit = () => {
        onUserCreate({name, email});
    };
    if(user === null){
    return(
        <div>
            <h2>Create User </h2>
            <input type="text"
                   value={name}
                   onChange={(e) => setName(e.target.value)}
                   placeholder="Name"
            />
            <input type="email"
                   value={email}
                   onChange={(e) => setEmail(e.target.value)}
                   placeholder="Email"
            />
            <button onClick={handleSubmit}>Submit</button>

        </div>
    );
    }
    return (
        <p>Welcome {name}!</p>

    )
}