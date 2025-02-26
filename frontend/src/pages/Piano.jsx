import Grabacion from "../components/piano/Grabacion";
import ComponentePiano from "../components/piano/Piano";
import { PianoProvider } from '../components/piano/PianoContext';
import * as Tone from "tone";


const Piano = () => {

    return (

        <PianoProvider>
        <div>
            <ComponentePiano />
        </div> 
        </PianoProvider>
    );
};

export default Piano;