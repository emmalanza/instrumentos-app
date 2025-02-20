package org.bugandbass.instrumentos_app_backend.models;

import java.util.List;

public abstract class Instrumento {
    private String nombre;
    private int id;
    private String tipo;

    public Instrumento(String nombre, int id, String tipo) {
        this.nombre = nombre;
        this.id = id;
        this.tipo = tipo;
    }
    
    public Instrumento(String nombre) {
        this.nombre = nombre;
    }    

    public String getNombre() {
        return this.nombre;
    }

    public int getId() {
        return this.id;
    }

    public String getTipo() {        
        return this.tipo;
    }

    public abstract List<String> tocarInstrumento();
}
