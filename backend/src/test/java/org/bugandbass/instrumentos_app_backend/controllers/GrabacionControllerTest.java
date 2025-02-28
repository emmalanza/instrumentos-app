package org.bugandbass.instrumentos_app_backend.controllers;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.*;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;


class GrabacionControllerTest {

    private GrabacionController grabacionController;

    @BeforeEach
    void setUp() {
        grabacionController = new GrabacionController();
    }

    @Test
    void testIndexReturnsJsonList() {
        String json = grabacionController.index();
        assertThat(json, containsString("Grabación 1"));
        assertThat(json, containsString("Grabación 2"));
        assertThat(json, containsString("Grabación 3"));
    }

    @Test
    void testShowReturnsJsonForId() {
        String json = grabacionController.show(5);
        assertThat(json, containsString("Grabación 5"));
    }

    @Test
    void testCreateParsesRequestBody() throws IOException {
        String inputJson = "{\"titulo\": \"Mi nueva grabación\"}\r\n";
        BufferedReader in = new BufferedReader(new StringReader(inputJson));

        String json = grabacionController.create(in);
        assertThat(json, containsString("Mi nueva grabación"));
    }

    @Test
    void testObjectToJson() {
        List<String> data = List.of("Uno", "Dos", "Tres");
        String json = grabacionController.objectToJson(data);

        assertThat(json, containsString("Uno"));
        assertThat(json, containsString("Dos"));
        assertThat(json, containsString("Tres"));
    }
}
