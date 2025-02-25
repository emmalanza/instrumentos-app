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
        return json;

    }

    public String responderSonido() {
        String json = this.obtenerSonido();
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type: application/json\r\n"
                + "Access-Control-Allow-Origin: http://localhost:5173\r\n"
                + "Access-Control-Allow-Methods: GET\r\n"
                + "Access-Control-Allow-Headers: Content-Type\r\n"
                + "\r\n"
                + json;
    }

}