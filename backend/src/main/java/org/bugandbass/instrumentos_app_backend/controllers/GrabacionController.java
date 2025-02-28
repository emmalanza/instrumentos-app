package org.bugandbass.instrumentos_app_backend.controllers;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class GrabacionController {
    public GrabacionController() {}
    public List<Grabacion> getGrabaciones(){
        RepositorioGrabaciones repositorioGrabaciones = new RepositorioGrabaciones();
        return repositorioGrabaciones.getGrabaciones();
    }

    public String index(){
        
        return objectToJson(getGrabaciones());
    }
    public String show(int id){
        List<Grabacion> grabaciones = getGrabaciones();
        Grabacion grabacion = grabaciones.find( grabacion -> grabacion.getId() == id);
        return objectToJson(grabacion);       
    }
    public String create(BufferedReader in) throws IOException {
        StringBuilder requestBody = new StringBuilder();
        String line;

        while ((line = in.readLine()) != null && !line.isEmpty());
        while (in.ready()) {  
            requestBody.append((char) in.read());
        }
        
        return requestBody.toString();
    }

    public String objectToJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public void responderGrabacion(String requestLine, BufferedWriter out, BufferedReader in) throws IOException {        
        String json = "";
        if(requestLine.startsWith("GET /grabaciones")){
            String[] parts = requestLine.split(" ");
            String path = parts[1];             
            if (path.matches("^/grabaciones/\\d+$")) {             
                String id = path.split("/")[2];
                json = show(Integer.parseInt(id));
            }
            if (path.equals("/grabaciones")) { 
                json = index();
            }
        }
        if(requestLine.startsWith("POST /grabaciones")){

            json = create(in);
            System.out.println("aqui");
            System.out.println(json);
        }
        
        byte[] responseBytes = json.getBytes("UTF-8");
        if(responseBytes.length == 0) return;

        out.write("HTTP/1.1 200 OK\r\n");
        out.write("Content-Type: application/json\r\n");
        out.write("Content-Length: " + responseBytes.length + "\r\n");
        out.write("Access-Control-Allow-Origin: http://localhost:5173\r\n");
        out.write("Access-Control-Allow-Methods: GET, POST, OPTIONS\r\n");
        out.write("Access-Control-Allow-Headers: Content-Type\r\n");
        out.write("\r\n");
        out.write(json);
        out.flush();
    }
}
