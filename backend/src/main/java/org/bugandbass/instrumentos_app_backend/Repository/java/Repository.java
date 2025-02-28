package org.bugandbass.instrumentos_app_backend.Repository.java;

import org.bugandbass.instrumentos_app_backend.models.Grabacion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Repository {

    public List<Grabacion> getGrabaciones() {
        List<Grabacion> grabaciones = new ArrayList<>();
        
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
}
