import { useState } from 'react';
import ComponentePiano from "../components/Piano";
import Cronometro from "../components/Cronometro";
import recButton from '../assets/img/recordButton.svg'; 

const Piano = () => {
    const [recording, setRecording] = useState(false);

    const toggleRecording = () => {
        setRecording(!recording);
    };

    return (
        <div className="relative flex flex-col items-center p-8 bg-gray-900 min-h-screen" id="teclado">
           <div className="teclado-container bg-black rounded-xl p-4 flex flex-col items-center w-fit md:w-3/4 lg:w-1/2"> 
               <div className="top-section w-full flex justify-between items-center mb-4"> 
                    <div className="cronometro-container bg-black text-white text-2xl  border  border-b-gray-1 p-2 rounded">
                    <Cronometro recording={recording} />
                </div>
                    <button className="record-button w-12 h-12" onClick={toggleRecording}>
                    <img src={recButton} alt="Rec" className={`w-full h-full ${recording ? "opacity-50" : ""}`} />
                    </button>
            </div>
            <div className="piano-container w-full max-h-[200px] overflow-x-auto"> 
                <ComponentePiano />
            </div>
           </div>
            <p className="mt-2 text-sm text-white">Usa las teclas A, W, S, E, D, F, T, J, Y, K, U, L, Ñ para tocar el piano</p>
        </div>
    );
};

export default Piano;