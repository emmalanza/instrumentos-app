package org.bugandbass.instrumentos_app_backend.Repository.java;

import org.bugandbass.instrumentos_app_backend.models.Grabacion;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Repository {
    
    public List<Grabacion> getGrabaciones() {
        return grabaciones;
    }

    private List<Grabacion> grabaciones;

    public Repository() {
        grabaciones= this.iniciarArray();
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
        
        grabaciones.add(new Grabacion(1, "titulo", cancion1));
        grabaciones.add(new Grabacion(2, "titulo", cancion2));
        grabaciones.add(new Grabacion(3, "titulo", cancion3));
        return grabaciones;

    }

    public void addGrabacion(String json) {
        Gson gson = new Gson();

        List<Grabacion> grabacion = gson.fromJson(json, new TypeToken<List<Grabacion>>() {}.getType());

        grabaciones.addAll(grabacion);

    }
}
