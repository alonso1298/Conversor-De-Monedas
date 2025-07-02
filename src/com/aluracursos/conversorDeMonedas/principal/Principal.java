package com.aluracursos.conversorDeMonedas.principal;

import com.aluracursos.conversorDeMonedas.modelos.Cambio;
import com.aluracursos.conversorDeMonedas.modelos.CambioRate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        Cambio tasa = null;
        String bienvenida = """
                ********************************************
                Sea bienvenido/a al Conversor De Monedas  :]
                
                1) Dollar =>> Peso Mexicano
                2) Peso Mexicano a Dolar
                3) Dollar =>> Peso Argentino
                4) Peso Argentino a Dollar
                5) Dollar =>> Peso Colombiano
                6) Peso Colombiano a Dollar
                7) Mostar ultima la ultima tasa de actualización
                8) Mostrar la siguiente tasa de actualización
                9) Salir
                Elija una opción valida:
                *********************************************
                """;

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/c5cba5ac6d1b22a222d33804/latest/USD"))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Respuesta JSON:");
            String json = response.body();

            CambioRate miCambio = gson.fromJson(json,CambioRate.class);
            tasa = new Cambio(miCambio);

        } catch (IOException | InterruptedException e) {
            System.out.println("Ocurrió un error al hacer la solicitud: " + e.getMessage());
        }

        while (true){
            System.out.println(bienvenida);
            int opcion = lectura.nextInt();

            System.out.print("Ingrese la cantidad a convertir: ");
            double cantidad = lectura.nextDouble();

            if(opcion == 9){
                System.out.println("Gracias por usar el conversor. ");
                break;
            }

            switch (opcion){
                case 1 -> {
                    double resultado = tasa.convertir("USD", "MXN", cantidad);
                    System.out.printf("%.2f USD = %.2f MXN%n", cantidad, resultado);
                }
                case 2 -> {
                    double resultado = tasa.convertir("MXN", "USD", cantidad);
                    System.out.printf("%.2f MXN = %.2f USD%n", cantidad, resultado);
                }
                case 3 -> {
                    double resultado = tasa.convertir("USD", "ARS", cantidad);
                    System.out.printf("%.2f USD = %.2f ARS%n", cantidad, resultado);
                }
                case 4 -> {
                    double resultado = tasa.convertir("ARS", "USD", cantidad);
                    System.out.printf("%.2f ARS = %.2f USD%n", cantidad, resultado);
                }
                case 5 -> {
                    double resultado = tasa.convertir("USD", "COP", cantidad);
                    System.out.printf("%.2f USD = %.2f COP%n", cantidad, resultado);
                }
                case 6 -> {
                    double resultado = tasa.convertir("COP", "USD", cantidad);
                    System.out.printf("%.2f COP = %.2f USD%n", cantidad, resultado);
                }
                case 7 -> System.out.println(tasa.getUltimaActualizacion());

                case 8 -> System.out.println(tasa.getSiguienteActualizacion());

                default -> System.out.println("Opcion no valida");
            }
        }

    }
}
