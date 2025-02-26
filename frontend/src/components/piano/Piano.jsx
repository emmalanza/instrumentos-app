import { useEffect, useState } from "react";
import * as Tone from "tone";
import './piano.css';
import { usePiano } from "./PianoContext";
import Grabacion from "./Grabacion";


const Piano = () => {
    const sintetizador = new Tone.Synth().toDestination();
    const {handleNotePlay} = usePiano();

    const teclasBlancas = ["A", "S", "D", "F", "J", "K", "L", "Ñ"];
    const teclasNegras = ["W", "E", "T", "Y", "U"];

    const teclasPiano = {
        "A": "C4", "W": "C#4", "S": "D4", "E": "D#4", "D": "E4",
        "F": "F4", "T": "F#4", "J": "G4", "Y": "G#4", "K": "A4",
        "U": "A#4", "L": "B4", "Ñ": "C5"
    };

    const posicionesNegras = {
        "W": "left-[72px]", "E": "left-[160px]", "T": "left-[335px]", "Y": "left-[424px]", "U": "left-[511px]"  
    };

    const [teclasActivas, setTeclasActivas] = useState({});

    const tocarTecla = (event) => {
        const tecla = event.key.toUpperCase();
        const nota = teclasPiano[tecla];
        if (nota) {
            sintetizador.triggerAttackRelease(nota, "8n");
            setTeclasActivas((prev) => ({ ...prev, [tecla]: true }));
            handleNotePlay(nota);
        }
    };

    const soltarTecla = (event) => {
        const tecla = event.key.toUpperCase();
        setTeclasActivas((prev) => ({ ...prev, [tecla]: false }));
    };

    useEffect(() => {
        window.addEventListener("keydown", tocarTecla);
        window.addEventListener("keyup", soltarTecla);
        return () => {
            window.removeEventListener("keydown", tocarTecla);
            window.removeEventListener("keyup", soltarTecla);
        };
    }, []);

  
    return (
        <div className="w-[775px] h-[605px] justify-self-center mt-10 rounded-2xl
        bg-gray-4 shadow-black shadow-2xl">

          <div className="w-full h-[181px] bg-gray-4/75 shadow-black shadow-xl rounded-2xl">
           <Grabacion/>
          </div>

          <div className="flex flex-col items-center p-4 w-full">

            <div className="relative flex  rounded-2xl p-2 bg-black h-[310px]">
              {teclasBlancas.map((key, index) => (
                <div
                  key={key}
                  className={`tecla-blanca 
                    ${teclasActivas[key] ? 'activada' : ''} 
                    ${index === 0 ? 'first' : ''}  {/* Clase para la primera tecla */}
                    ${index === teclasBlancas.length - 1 ? 'last' : ''}  {/* Clase para la última tecla */}
                  `}
                >
                  {key}
                </div>
              ))}
              
              {teclasNegras.map((key) => (
                <div
                  key={key}
                  className={`tecla-negra 
                    ${teclasActivas[key] ? 'activada' : ''} ${posicionesNegras[key]} `}  
                >
                  {key}
                </div>
              ))}
            </div>
            <p className="mt-2 text-sm text-gray-400">Usa las teclas A, W, S, E, D, F, T, J, Y, K, U, L, Ñ para tocar el piano</p>
          </div>
        </div>
      );
};

export default Piano;