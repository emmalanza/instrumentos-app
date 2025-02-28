package org.bugandbass.instrumentos_app_backend.models;

import java.util.List;


public class Piano extends Instrumento{
    private static Piano instance;
    private List<Nota> notas;

    private Piano(String nombre, String tipo) {
        super(nombre, tipo);
        this.notas= getNotas();

    }

    public static Piano getInstance() {
        if (instance == null) {
            instance = new Piano("Piano", "Cuerda");
        }
        return instance;
    }
    @Override
    public List<Nota> tocarInstrumento(){
        return this.notas;
    }
    public List<Nota> getNotas() {
        return List.of(
            new Nota("A", "C4"), new Nota("W", "C#4"),
            new Nota("S", "D4"), new Nota("E", "D#4"),
            new Nota( "D", "E4"), new Nota( "F", "F4"),
            new Nota( "T", "F#4"), new Nota("J", "G4"),
            new Nota("Y", "G#4"), new Nota("K", "A4"),
            new Nota("U", "A#4"), new Nota("L", "B4"),
            new Nota("Ñ", "C5")
        );
    }
}
