import java.time.LocalDate;

public class Cliente {
    private String dni;
    private String nombre;
    private int numSocio;
    private String direccion;
    private LocalDate fechaNacimiento;
    private LocalDate fechaBaja;
    private Pelicula [] peliculasAlquiladas;
    private static int contadorSocio = 1;
    private int nAlquiladas;
    
    public Cliente(String dni, String nombre, String direccion, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.numSocio = this.contadorSocio;
        this.contadorSocio++;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaBaja = null;
        this.peliculasAlquiladas = new Pelicula[100];
        this.nAlquiladas = 0;
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

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public int getnAlquiladas() {
        return nAlquiladas;
    }

    public String mostraInfocliente(){
        String infoCliente = String.format("Dni: %s, Nombre: %s, Direccion: %s, Fecha de nacimiento: %s",
        this.dni, this.nombre, this.direccion, this.fechaNacimiento);
        return infoCliente;
    }

    public boolean addPelicula(Pelicula p1){
        boolean isAdd = false;
        if(p1 != null){
            this.peliculasAlquiladas[nAlquiladas] = p1;
            nAlquiladas++;
        }
        return isAdd;
    }

    public boolean quitarPelicula(Pelicula p1){
        boolean isRemove = false;
        if(p1 != null){
            nAlquiladas--;
        }
        return isRemove;
    }

    public void mostrarPeliculas(){
        System.out.println("Peliculas alquiladas: ");
        for (int i = 0; i < nAlquiladas; i++) {
            System.out.println(peliculasAlquiladas[i].mostrarInfoPelicula());
        }
    }
}
