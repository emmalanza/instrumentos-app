import { useState } from "react";
import Cronometro from "../components/Cronometro";
import recordButton from '../assets/img/recordButton.svg';


const Piano = () => {
    const [recording, setRecording] = useState(false);
const toggleRecording = () => {
        setRecording(!recording);
    };
}