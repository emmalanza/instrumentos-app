import React from 'react';
import * as Tone from 'tone';

const Piano = () => {
    const sintetizador = new Tone.Synth().toDestination();

    const teclasPiano = {
        a: 'C4',
        w: 'C#4',
        s: 'D4',
        e: 'D#4',
        d: 'E4',
        f: 'F4',
        t: 'F#4',
        j: 'G4',
        y: 'G#4',
        k: 'A4',
        u: 'A#4',
        l: 'B4',
        ñ: 'C5',
    };

    const tocarTecla = (event) => {
        const nota = teclasPiano[event.key];
            sintetizador.triggerAttack(nota);
    };
    
    const soltarTecla = (event) => {
        const nota = teclasPiano[event.key];
            sintetizador.triggerRealease(nota);
    };

};