package com.aluracursos.conversorDeMonedas.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
//import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        //Scanner lectura = new Scanner(System.in);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/c5cba5ac6d1b22a222d33804/latest/USD"))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Respuesta JSON:");
            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            System.out.println("Ocurrió un error al hacer la solicitud: " + e.getMessage());
        }

    }
}
