package org.bugandbass.instrumentos_app_backend;

import org.bugandbass.instrumentos_app_backend.controllers.InstrumentoController;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }
    public static void main(String[] args) {
        InstrumentoController instrumentoController = new InstrumentoController();
        instrumentoController.obtenerSonido();
        
    }
}
