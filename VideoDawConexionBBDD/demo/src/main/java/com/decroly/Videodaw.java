package com.decroly;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
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

    public boolean registrarPelicula(Pelicula p){
        boolean isAdd = false;
        if(p != null){
            articulosRegistrados.add(p);
        }
        return isAdd;
    }

    public boolean registrarVideojuego(Videojuego v){
        boolean isAdd = false;
        if(v != null){
            articulosRegistrados.add(v);
        }
        return isAdd;
    }

    public boolean registrarCliente(Cliente cliente) throws ClienteYaRegistradoException{
        for (Cliente c : clientesRegistrados) {
            if(cliente.getDni().equals(c.getDni())){
                throw new ClienteYaRegistradoException("Ya existe un cliente registrado con el dni: " + cliente.getDni() + ".");
            }
        }
        clientesRegistrados.add(cliente);
        return true;
    }

    public String alquilarArticulo(int cod, int codSocio) throws ArticuloYaAlquiladoException{
        Articulo articulo = null;
        Cliente cliente = null;
        for (Articulo a : articulosRegistrados) {
            if(a.getCod()==cod){
                articulo = a;
            }
        }
        for (Cliente c : clientesRegistrados) {
            if(c.getCodSocio()==codSocio){
                cliente = c;
            }
        }
        if(articulo == null){
            return "El articulo no existe";
        }
        if(cliente == null){
            return "El cliente no existe";
        }
        if(articulo instanceof Pelicula && ((Pelicula) articulo).isAlquilada()){
            throw new ArticuloYaAlquiladoException("El artículo ya está alquilado.");
        } else if(articulo instanceof Videojuego && ((Videojuego) articulo).isAlquilada()){
            throw new ArticuloYaAlquiladoException("El artículo ya está alquilado.");
        }
        LocalDateTime fechaAlquiler = LocalDateTime.now();
        if (articulo instanceof Pelicula) {
            ((Pelicula) articulo).setFechaAlquiler(fechaAlquiler);
            ((Pelicula) articulo).setIsAlquilada(true);
        } else if (articulo instanceof Videojuego) {
            ((Videojuego) articulo).setFechaAlquiler(fechaAlquiler);
            ((Videojuego) articulo).setIsAlquilada(true);
        }
        cliente.agregarArticuloAlquilado(articulo);
        return "Artículo alquilado exitosamente a " + cliente.getNombre();
            }

        public String devolverArticulo(int cod, int codSocio) throws TiempoExcedidoException{
                Articulo articulo = null;
                Cliente cliente = null;
                for (Articulo a : articulosRegistrados) {
                    if(a.getCod()==cod){
                        articulo = a;
                    }
                }
                for (Cliente c : clientesRegistrados) {
                    if(c.getCodSocio()==codSocio){
                        cliente = c;
                    }
                }
                if(articulo == null){
                    return "El articulo no existe";
                }
                if(cliente == null){
                    return "El cliente no existe";
                }

                LocalDateTime fechaDevolucion = LocalDateTime.now();
                if (articulo instanceof Pelicula) {
                    if (!((Pelicula) articulo).isAlquilada()) {
                        return "El artículo no está alquilado";
                    }
                    Period dias = Period.between(((Pelicula) articulo).getFechaAlquiler().toLocalDate(), fechaDevolucion.toLocalDate());
                    if(dias.getDays() >= 2){
                        throw new TiempoExcedidoException("Tiempo de alquiler excedido");
                    }
                    ((Pelicula) articulo).setIsAlquilada(false);
                    ((Pelicula) articulo).setFechaAlquiler(null);
                } else if (articulo instanceof Videojuego) {
                    if (!((Videojuego) articulo).isAlquilada()) {
                        return "El artículo no está alquilado";
                    }
                    Period dias = Period.between(((Videojuego) articulo).getFechaAlquiler().toLocalDate(), fechaDevolucion.toLocalDate());
                    if(dias.getDays() >= 2){
                        throw new TiempoExcedidoException("Tiempo de alquiler excedido");
                    }
                    ((Videojuego) articulo).setIsAlquilada(false);
                    ((Videojuego) articulo).setFechaAlquiler(null);
                }
                cliente.eliminarArticuloAlquilado(articulo);
                return "Artículo devuelto exitosamente por " + cliente.getNombre();
            }

    public String darBajaCliente(int codSocio){  
        for (Cliente cliente : clientesRegistrados) {
            if (cliente.getCodSocio() == codSocio) {
                clientesRegistrados.remove(cliente);
            return cliente.toString();
        }
    }
        return "No se ha encontrado el contacto";
    }

    public String darBajaArticulo(int cod){
        for (Articulo articulo : articulosRegistrados) {
            if (articulo.getCod() == cod) {
                articulosRegistrados.remove(articulo);
                return articulo.toString();
            }
        }
        return "No se ha encontrado el articulo";
    }
}
