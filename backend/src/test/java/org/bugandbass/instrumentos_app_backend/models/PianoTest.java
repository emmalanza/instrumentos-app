package org.bugandbass.instrumentos_app_backend.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;


public class PianoTest {
    Piano piano;
    @BeforeEach
    void setUp() {
        piano = new Piano("Piano","Cuerda") {};
        
    }
    @Test
    void testInstanciarPiano() {
        assertThat(piano, is(notNullValue()));
        assertThat(piano, is(instanceOf(Instrumento.class)));
        assertThat(piano, is(instanceOf(Piano.class)));
    }
    @Test
    void testTocarPiano() {
        List<Integer> tocarInstrumento = piano.tocarInstrumento();
        assertThat(tocarInstrumento, is(instanceOf(List.class)));
        assertThat(tocarInstrumento, is(notNullValue()));
        assertThat(tocarInstrumento.size(), is(3));
        assertThat(tocarInstrumento.get(0), is(1));
        assertThat(tocarInstrumento.get(1), is(2));
        assertThat(tocarInstrumento.get(2), is(3));
    }

}
