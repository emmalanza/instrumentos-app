package org.bugandbass.instrumentos_app_backend.models;

import java.util.List;
import java.util.Map;

public class Grabacion {
    private int id;
    private String nombreCancion;
    private List<Map<String, String>> listaNotas;  // Changed this line

    // Constructores, getters y setters
    public Grabacion() {}

    public Grabacion(int id, String nombreCancion, List<Map<String, String>> listaNotas) {  // Changed this line
        this.id = id;
        this.nombreCancion = nombreCancion;
        this.listaNotas = listaNotas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public List<Map<String, String>> getListaNotas() {  // Changed this line
        return listaNotas;
    }

    public void setListaNotas(List<Map<String, String>> listaNotas) {  // Changed this line
        this.listaNotas = listaNotas;
    }
}
