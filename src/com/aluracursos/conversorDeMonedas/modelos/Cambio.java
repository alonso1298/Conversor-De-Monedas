package com.aluracursos.conversorDeMonedas.modelos;

import java.util.Map;

public class Cambio {
    private String ultimaActualizacion;
    private String siguienteActualizacion;
    private String monedaSeleccionada;
    private Map<String, Double> conversiones;

    public Cambio(CambioRate miCamabio){
        this.ultimaActualizacion = miCamabio.time_last_update_utc();
        this.siguienteActualizacion = miCamabio.time_next_update_utc();
        this.monedaSeleccionada = miCamabio.base_code();
        this.conversiones = miCamabio.conversion_rates();
    }

    public String getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public String getSiguienteActualizacion() {
        return siguienteActualizacion;
    }

    public String getMonedaSeleccionada() {
        return monedaSeleccionada;
    }

    public Map<String, Double> getConversiones() {
        return conversiones;
    }

    public void setMonedaSeleccionada(String monedaSeleccionada) {
        this.monedaSeleccionada = monedaSeleccionada;
    }

    public double convertir (String monedaOrigen, String monedaDestino, double cantidad) {
        double tasaOrigen = conversiones.get(monedaOrigen);
        double tasaDestino = conversiones.get(monedaDestino);

        //Convertimos la cantidad a USD (base), luego a destino
        double cantidadEnUSD = cantidad / tasaOrigen;
        double resultado = cantidadEnUSD * tasaDestino;

        return resultado;

    }
}
