package org.bugandbass.instrumentos_app_backend.models;

import java.util.List;

public class Piano extends Instrumento{
    private List<Nota> notas;

    public Piano(String nombre, String tipo) {
        super(nombre, tipo);
        this.notas= getNotas();

    }
    @Override
    public List<Nota> tocarInstrumento(){
        return this.notas;
    }
    public List<Nota> getNotas() {
        int contador=1;
        return List.of(
            new Nota(contador++, "A", "C4"), new Nota(contador++, "W", "C#4"),
            new Nota(contador++, "S", "D4"), new Nota(contador++, "E", "D#4"),
            new Nota(contador++, "D", "E4"), new Nota(contador++, "F", "F4"),
            new Nota(contador++, "T", "F#4"), new Nota(contador++, "J", "G4"),
            new Nota(contador++, "Y", "G#4"), new Nota(contador++, "K", "A4"),
            new Nota(contador++, "U", "A#4"), new Nota(contador++, "L", "B4"),
            new Nota(contador++, "Ñ", "C5")
        );
    }
}
