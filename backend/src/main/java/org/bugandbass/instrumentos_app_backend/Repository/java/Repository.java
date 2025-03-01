package org.bugandbass.instrumentos_app_backend.Repository.java;

import org.bugandbass.instrumentos_app_backend.models.Grabacion;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Repository {

    private static Repository instance;
    private List<Grabacion> grabaciones;
    private int id = 1;

    private Repository() {
        this.grabaciones = this.iniciarArray();
    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public List<Grabacion> iniciarArray() {
        grabaciones = new ArrayList<>();
        List<Map<String, String>> cancion1 = Arrays.asList(
                Map.of("C3", "1"),
                Map.of("C3", "1"),
                Map.of("C3", "1")
        );

        List<Map<String, String>> cancion2 = Arrays.asList(
                Map.of("C3", "1"),
                Map.of("C3", "1"),
                Map.of("C3", "1")
        );

        List<Map<String, String>> cancion3 = Arrays.asList(
                Map.of("C3", "1"),
                Map.of("C3", "1"),
                Map.of("C3", "1")
        );

        grabaciones.add(new Grabacion(id++, "titulo", cancion1));
        grabaciones.add(new Grabacion(id++, "titulo", cancion2));
        grabaciones.add(new Grabacion(id++, "titulo", cancion3));
        return grabaciones;
    }

    public void addGrabacion(String json) {
        Gson gson = new Gson();
        Grabacion grabacion = gson.fromJson(json, Grabacion.class);
        if (grabacion != null) {
            grabacion.setId(id++);
            grabaciones.add(grabacion);
        }
    }

    public void deleteGrabacion(String json) {
        Gson gson = new Gson();
        Grabacion grabacionToDelete = gson.fromJson(json, Grabacion.class);
        if (grabacionToDelete != null) {
            grabaciones.removeIf(grabacion -> grabacion.getId() == grabacionToDelete.getId());
        }
    }

    public List<Grabacion> getGrabaciones() {
        return grabaciones;
    }
}