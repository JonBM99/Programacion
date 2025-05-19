package com.decroly;

import java.time.LocalDate;
import java.util.LinkedList;

import com.Articulo;

public class Videodaw {
    private String cif;
    private String direccion;
    private LocalDate fechaAlta;
    private LinkedList <Articulo> articulosRegistrados;
    private LinkedList <Cliente> clientesRegistrados;
    
    
    
    public Videodaw(String cif, String direccion) {
        this.cif = cif;
        this.direccion = direccion;
        this.fechaAlta = LocalDate.now();
        this.articulosRegistrados = new LinkedList<>();
        this.clientesRegistrados = new LinkedList<>();
    }
    public String getCif() {
        return cif;
    }
    public String getDireccion() {
        return direccion;
    }
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }
    public LinkedList<Articulo> getArticulosRegistrados() {
        return articulosRegistrados;
    }
    public LinkedList<Cliente> getClientesRegistrados() {
        return clientesRegistrados;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VideoDaw: ");
        sb.append("cif: ").append(cif);
        sb.append(", direccion: ").append(direccion);
        sb.append(", fechaAlta: ").append(fechaAlta);
        sb.append(", articulosRegistrados: ").append(articulosRegistrados);
        sb.append(", clientesRegistrados: ").append(clientesRegistrados);
        sb.append('.');
        return sb.toString();
    }
}