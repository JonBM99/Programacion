package com.decroly;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.Articulo;

public class Videojuego extends Articulo {
    
    private int generoV;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy hh:mm:ss");
    
    public Videojuego(String titulo, int generoV) {
        super(titulo);
        this.generoV = generoV;
        this.fechaAlquiler = null;
        this.isAlquilada = false;
    }

    public int getGenero() {
        return generoV;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public boolean isAlquilada() {
        return isAlquilada;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public void setIsAlquilada(boolean isAlquilada) {
        this.isAlquilada = isAlquilada;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Videojuego: ");
        sb.append("cod: ").append(cod);
        sb.append(" ,titulo: ").append(titulo);
        sb.append(" ,genero: ").append(generoV);
        sb.append('.' + "\n");
        return sb.toString();
    }
}