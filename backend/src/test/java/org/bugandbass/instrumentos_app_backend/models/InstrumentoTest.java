package org.bugandbass.instrumentos_app_backend.models;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class InstrumentoTest {
    @Test
    void testInstanciaInstrumento() {
        Instrumento instrumento = new Instrumento("Piano"){};
        assertThat(instrumento, is(notNullValue()));
        assertThat(instrumento, is(instanceOf(Instrumento.class)));
    }

}
