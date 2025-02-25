package org.bugandbass.instrumentos_app_backend.models;

public class Nota {
    private int idNota;
    private String nombre;
    private String tecla;
    

    // Constructor
    public Nota(int idNota,String tecla, String nombre) {
        this.idNota = idNota;
        this.tecla = tecla;
        this.nombre = nombre;
        
    }

    // Getters
    public int getIdNota() {
        return idNota;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTecla() {
        return tecla;
    }
    
}
