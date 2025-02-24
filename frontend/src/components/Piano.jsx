import { useEffect } from "react";
import * as Tone from "tone";

const Piano = () => {
    const sintetizador = new Tone.Synth().toDestination();

    const teclasBlancas = ["A", "S", "D", "F", "J", "K", "L", "Ñ"];
    const teclasNegras = ["W", "E", "T", "Y", "U"];

    const teclasPiano = {
        "A": "C4", "W": "C#4", "S": "D4", "E": "D#4", "D": "E4", 
        "F": "F4", "T": "F#4", "J": "G4", "Y": "G#4", "K": "A4", 
        "U": "A#4", "L": "B4", "Ñ": "C5"
    };

    const posicionesNegras = {
        "W": "left-[44px]", "E": "left-[100px]", "T": "left-[216px]", "Y": "left-[268px]", "U": "left-[324px]"
    };

    const tocarTecla = (event) => {
        const nota = teclasPiano[event.key.toUpperCase()];
        if (nota) sintetizador.triggerAttackRelease(nota, "8n");
    };

    useEffect(() => {
        window.addEventListener("keydown", tocarTecla);
        return () => {
            window.removeEventListener("keydown", tocarTecla);
        };
    }, []);

    return (
        <div className="flex flex-col items-center p-4 bg-gray-900 min-h-screen">
            <div className="relative flex bg-gray-600 rounded-lg border border-black p-2">
                {teclasBlancas.map((key, index) => (
                    <div key={key} className="relative w-14 h-40 bg-[linear-gradient(180deg,_#DCDCDC_0%,_#F7F7F7_100%)] rounded-bl-[13.7119px] rounded-br-[13.7119px] border-2 border-black text-lg font-bold flex items-end justify-center shadow-md active:bg-gray-400 focus:scale-95 focus:brightness-90 transition-all duration-100">
                            {key}
                    </div>
                ))}
                {teclasNegras.map((key, index) => (
                    <div key={key} className={`absolute top-2 w-10 h-24 text-white bg-[linear-gradient(180deg,_#121212_0%,_#232323_100%)] border-[2.74237px] border-[#171717] shadow-[0px_16.4542px_16.4542px_rgba(0,0,0,0.23)] rounded-bl-[13.7119px] rounded-br-[13.7119px] flex items-center justify-center z-10 ${posicionesNegras[key]}`}>
                        {key}
                    </div>
                ))}
            </div>

        </div>
    );
};


export default Piano;
