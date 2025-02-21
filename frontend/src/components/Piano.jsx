import React, { useEffect } from "react";
import * as Tone from "tone";

const Piano = () => {
    const sintetizador = new Tone.Synth().toDestination();

    const teclasBlancas = ["A", "S", "D", "F", "J", "K", "L", "Ñ"];
    const teclasNegras = { "W": "C#4", "E": "D#4", "T": "F#4", "Y": "G#4", "U": "A#4" };

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
            <div className="relative flex bg-gray-100 rounded-lg border border-black p-2">
                {teclasBlancas.map((key, index) => (
                    <div key={key} className="relative w-14">
                        <button className="w-14 h-40 bg-white border-2 border-black text-lg font-bold flex items-end justify-center shadow-md active:bg-gray-400">
                            {key}
                        </button>
                    </div>
                ))}
                {Object.entries(teclasNegras).map(([key, nota]) => (
                    <div key={key} className={`absolute top-2 w-10 h-24 bg-black text-white border border-black flex items-center justify-center active:bg-gray-700 z-10 ${posicionesNegras[key]}`}> 
                        {key}
                    </div>
                ))}
            </div>
            <p className="mt-2 text-sm text-gray-400">Usa las teclas A, W, S, E, D, F, T, J, Y, K, U, L, Ñ para tocar el piano</p>
        </div>
    );
};

export default Piano;
