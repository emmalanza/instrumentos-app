package org.bugandbass.instrumentos_app_backend.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

public class InstrumentoTest {
    Instrumento instrumento;
    @BeforeEach
    void setUp() {
        instrumento = new Instrumento("Piano", 1, "Cuerda") {};
    }
    @Test
    void testInstanciaInstrumento() {
        assertThat(instrumento, is(notNullValue()));
        assertThat(instrumento, is(instanceOf(Instrumento.class)));
    }
    @Test
    void testGettersIntrumento() {

        assertThat(instrumento.getNombre(), is("Piano"));
        assertThat(instrumento.getId(), is(1));
        assertThat(instrumento.getTipo(), is("Cuerda"));
    }

}
