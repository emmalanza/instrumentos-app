package org.bugandbass.instrumentos_app_backend.models;

import java.util.List;

public class Piano extends Instrumento{
    public Piano(String nombre, String tipo) {
        super(nombre, tipo);

    }
    @Override
    public List<Nota> tocarInstrumento() {
        return List.of(
            new Nota("A", "C4"),
            new Nota("W", "C#4"),
            new Nota("S", "D4"),
            new Nota("E", "D#4"),
            new Nota("D", "E4"),
            new Nota("F", "F4"),
            new Nota("T", "F#4"),
            new Nota("J", "G4"),
            new Nota("Y", "G#4"),
            new Nota("K", "A4"),
            new Nota("U", "A#4"),
            new Nota("L", "B4"),
            new Nota("Ñ", "C5")
        );
    }
}
