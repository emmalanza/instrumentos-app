import { useState } from 'react';
import ComponentePiano from "../components/piano/Piano";


const Piano = () => {
    const [recording, setRecording] = useState(false);

    const toggleRecording = () => {
        setRecording(!recording);
    };

    return (

                <ComponentePiano />
            
        
    );
};

export default Piano;