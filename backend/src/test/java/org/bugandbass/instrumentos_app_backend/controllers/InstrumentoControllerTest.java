package org.bugandbass.instrumentos_app_backend.controllers;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class InstrumentoControllerTest {
     @Test
    void testObtenerSonido() {
        InstrumentoController instrumentoController = new InstrumentoController();
        String sonido = instrumentoController.obtenerSonido();
        assertThat(sonido, is(notNullValue()));
        assertFalse(sonido.isBlank());
        assertThat(sonido, is(instanceOf(String.class)));
    }
    @Test
    void testResponderSonido() throws IOException {
        InstrumentoController controller = new InstrumentoController();
        
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream));

        controller.responderSonido(bufferedWriter);

        String responseOutput = byteArrayOutputStream.toString();

        assertTrue(responseOutput.contains("HTTP/1.1 200 OK"));
        assertTrue(responseOutput.contains("Content-Type: application/json"));
        assertTrue(responseOutput.contains("Access-Control-Allow-Origin: http://localhost:5173"));
        assertTrue(responseOutput.contains("Access-Control-Allow-Methods: GET"));
    }
   
}
