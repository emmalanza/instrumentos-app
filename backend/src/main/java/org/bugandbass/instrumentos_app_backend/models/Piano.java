package org.bugandbass.instrumentos_app_backend.models;

import java.util.List;

public class Piano extends Instrumento{
    public Piano(String nombre, String tipo) {
        super(nombre, tipo);

    }
    @Override
    public List<Integer> tocarInstrumento() {
        return List.of(1, 2, 3);
    }
}
