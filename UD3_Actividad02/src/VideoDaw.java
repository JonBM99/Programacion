import java.time.LocalDate;

public class VideoDaw {
    private String cif;
    private String direccion;
    private LocalDate fechaAlta;
    private Pelicula [] peliculasRegistradas;
    private Cliente [] clienteRegistrados;
    private int nPelisRegistradas;
    private int nClientesRegistrados;
    
    public VideoDaw(String cif, String direccion, LocalDate fechaAlta) {
        this.cif = cif;
        this.direccion = direccion;
        this.fechaAlta = fechaAlta;
        this.nPelisRegistradas = 0;
        this.nClientesRegistrados = 0;
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

    public Pelicula[] getPeliculasRegistradas() {
        return peliculasRegistradas;
    }

    public Cliente[] getClienteRegistrados() {
        return clienteRegistrados;
    }

    public String mostrarInfoVideoclub(){
        String infoVideoclub = String.format("CIF: %s, Direccion: %s, Fecha de Alta: %s, Peliculas registradas: %s, Clientes registrados: %s .",
        this.cif, this.direccion, this.fechaAlta, this.nPelisRegistradas, this.nClientesRegistrados);
        return infoVideoclub;
    }

    public void mostrarClientesRegistrados() {
        System.out.println("Clientes registrados:");
        for (int i = 0; i < nClientesRegistrados; i++) {
            clienteRegistrados[i].mostrarInfoCliente();
        }
    }

    // Método para registrar cliente
    public void registrarCliente(Cliente cliente) {
        for (int i = 0; i < nClientesRegistrados; i++) {
            if (clienteRegistrados[i].getNumSocio().equals(cliente.getNumSocio())) {
                System.out.println("Cliente ya registrado.");
                return;
            }
        }
        if (nClientesRegistrados < clienteRegistrados.length) {
            clienteRegistrados[nClientesRegistrados++] = cliente;
            System.out.println("Cliente registrado con éxito.");
        } else {
            System.out.println("No se pueden registrar más clientes.");
        }
    }

    // Método para alquilar una película
    public void alquilarPelicula(Pelicula pelicula, Cliente cliente) {
        if (pelicula.isAlquilada()) {
            System.out.println("La película ya está alquilada.");
        } else {
            pelicula.setAlquilada(true);
            cliente.agregarPeliculaAlquilada(pelicula);
            System.out.println("Película alquilada con éxito.");
        }
    }

    // Método para devolver una película
    public void devolverPelicula(Pelicula pelicula, Cliente cliente) {
        if (!pelicula.isAlquilada()) {
            System.out.println("La película no está alquilada.");
        } else {
            pelicula.setAlquilada(false);
            System.out.println("Película devuelta con éxito.");
        }
    }

    // Método para dar de baja un cliente
    public void darBajaCliente(Cliente cliente) {
        for (int i = 0; i < nClientesRegistrados; i++) {
            if (clienteRegistrados[i] == cliente) {
                clienteRegistrados[i] = clienteRegistrados[nClientesRegistrados - 1];
                clienteRegistrados[nClientesRegistrados - 1] = null;
                nClientesRegistrados--;
                System.out.println("Cliente dado de baja.");
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    // Método para dar de baja una película
    public void darBajaPelicula(Pelicula pelicula) {
        for (int i = 0; i < nPelisRegistradas; i++) {
            if (peliculasRegistradas[i] == pelicula) {
                peliculasRegistradas[i] = peliculasRegistradas[nPelisRegistradas - 1];
                peliculasRegistradas[nPelisRegistradas - 1] = null;
                nPelisRegistradas--;
                System.out.println("Película dada de baja.");
                return;
            }
        }
        System.out.println("Película no encontrada.");
    }

    // Método para registrar una película
    public void registrarPelicula(Pelicula pelicula) {
        if (nuPelisRegistradas < peliculasRegistradas.length) {
            peliculasRegistradas[nPelisRegistradas++] = pelicula;
            System.out.println("Película registrada con éxito.");
        } else {
            System.out.println("No se pueden registrar más películas.");
        }
    }
    
}

