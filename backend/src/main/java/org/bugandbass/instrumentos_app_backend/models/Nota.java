package org.bugandbass.instrumentos_app_backend.models;

public class Nota {
    private static int contadorNota = 1; // Contador estático para IDs únicos
    private final int idNota;
    private String nombre;
    private String tecla;
    

    // Constructor
    public Nota(String tecla, String nombre) {
        this.idNota = contadorNota++;
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
