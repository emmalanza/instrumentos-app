package org.bugandbass.instrumentos_app_backend.controllers;

import org.bugandbass.instrumentos_app_backend.models.Piano;

public class InstrumentoController {
    private Piano piano;
    InstrumentoController(){
        this.piano = new Piano("Piano", "Cuerda");
    }

}