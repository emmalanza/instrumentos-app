package org.bugandbass.instrumentos_app_backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.bugandbass.instrumentos_app_backend.controllers.InstrumentoController;

public final class App {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Servidor escuchando en puerto 8080...");
        
        InstrumentoController instrumentoController = new InstrumentoController();
        //Grabacion grabacion=new Grabacion();

        while (true) {
            Socket clientSocket = serverSocket.accept();
            try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))
            ){
                String requestLine = in.readLine();
                System.out.println("Solicitud recibida: " + requestLine);

                if (requestLine == null) continue;

                String response;
                if (requestLine.startsWith("GET /piano/notas")) {//esto necesita al controlador Instrumento
                    response = instrumentoController.responderSonido();
                } else if (requestLine.startsWith("GET /grabaciones")) {//esto necesita del controlador de grabaciones
                    response = "HTTP/1.1 200 En construcción\r\n\r\n";
                } else if (requestLine.startsWith("GET /salir")) {
                    response = "HTTP/1.1 200 OK\r\n\r\nServidor finalizando";
                    out.write(response);
                    out.flush();
                    break;
                } else {
                    response = "HTTP/1.1 404 Not Found\r\n\r\n";
                }
                
                out.write(response);
                out.flush();
            }
        }
        serverSocket.close();
    }
}
