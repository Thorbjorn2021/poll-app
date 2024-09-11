import CreateUserComponent from "./components/CreateUserComponent.jsx";
import {useState} from "react";

function App(){
    const [user, setUser] = useState(null);

    const handleUserCreation = (userData) => {
        console.log(userData);
        setUser(userData);
    };

    return(
        <div>
            <CreateUserComponent onUserCreate={handleUserCreation} user={user}></CreateUserComponent>
        </div>
    )
}

export default App;