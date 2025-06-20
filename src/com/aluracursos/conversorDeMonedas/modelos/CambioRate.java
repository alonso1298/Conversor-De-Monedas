package com.aluracursos.conversorDeMonedas.modelos;

public record CambioRate(String time_last_update_utc,
                         String time_next_update_utc,
                         String basecode,
                         String conversion_rates) {
}
