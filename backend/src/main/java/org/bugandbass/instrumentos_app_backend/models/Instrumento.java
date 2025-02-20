package org.bugandbass.instrumentos_app_backend.models;

public abstract class Instrumento {
    private String nombre;

    public Instrumento(String nombre) {
        this.nombre = nombre;
    }
}
