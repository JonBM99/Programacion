import java.time.LocalDate;

public class Cliente {
    private static int nSocio = 1;

    private String dni;
    private String nombre;
    private int numSocio;
    private String direccionCliente;
    private LocalDate fechaNacimiento;
    private LocalDate fechaBaja;
    private Pelicula [] peliculasAlquiladas;
    private int nPeliculas;
    private boolean isRegistrado;
    private Cliente [] clientesRegistrados;
    private int nCliente;

    public Cliente(String dni, String nombre, String direccion, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.numSocio = this.nSocio;
        nSocio++;
        this.direccionCliente = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaBaja = fechaBaja;
        this.peliculasAlquiladas = new Pelicula [100];
        this.nPeliculas = 0;
        this.isRegistrado = false;
        this.clientesRegistrados = new Cliente [100];
        this.nCliente = 0;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumSocio() {
        return numSocio;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public Pelicula[] getPeliculasAlquiladas() {
        return peliculasAlquiladas;
    }

    public boolean isRegistrado(){
        return isRegistrado;
    }

    public String mostrarInfoCliente(){
        String infoCliente = String.format("DNI: %s, Nombre: %s, Numero de socio: Cliente-0%s, Direccion: %s, Fecha de nacimiento: %s, Peliculas alquiladas: %s",
        this.dni, this.nombre, this.numSocio, this.direccionCliente, this.fechaNacimiento, this.nPeliculas);
        return infoCliente;
    }

    public void mostrarPeliculasAlquiladas() {
        System.out.println("Películas alquiladas por " + nombre + ":");
        for (Pelicula p : peliculasAlquiladas) {
            if (p != null) {
                p.mostrarInfoPelicula();
            }
        }
    }

    public void agregarPeliculaAlquilada(Pelicula p) {
        for (int i = 0; i < peliculasAlquiladas.length; i++) {
            if (peliculasAlquiladas[i] == null) {
                peliculasAlquiladas[i] = p;
                break;
            }
        }
    }
}
