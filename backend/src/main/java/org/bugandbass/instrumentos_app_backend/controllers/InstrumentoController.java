package org.bugandbass.instrumentos_app_backend.controllers;

import java.util.List;

import org.bugandbass.instrumentos_app_backend.models.Nota;
import org.bugandbass.instrumentos_app_backend.models.Piano;

import com.google.gson.Gson;

public class InstrumentoController {
    private Piano piano;
    private Gson gson;

    public InstrumentoController(){
        this.piano = new Piano("Piano", "Cuerda");
        this.gson = new Gson();
    }

    public String obtenerSonido(){
        List<Nota> tocarInstrumento = this.piano.tocarInstrumento();
        String json = gson.toJson(tocarInstrumento);
        System.out.println(json);
        return json;

    }

}