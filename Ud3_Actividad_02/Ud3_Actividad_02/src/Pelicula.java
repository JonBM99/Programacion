import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pelicula {
    private int cod;
    private String titulo;
    private Genero genero;
    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;
    private static int contador = 1;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy hh:mm:ss");

    public Pelicula(String titulo, Genero genero) {
        this.cod = this.contador;
        this.contador++;
        this.titulo = titulo;
        this.genero = genero;
        this.fechaRegistro = LocalDate.now();
        this.fechaBaja = fechaBaja;
        this.fechaAlquiler = fechaAlquiler;
        this.isAlquilada = false;
    }

    public int getCod() {
        return cod;
    }

    public String getTitulo() {
        return titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public boolean isAlquilada() {
        return isAlquilada;
    }

    public String mostrarInfoPelicula(){
        String infoPelicula = String.format("Codigo: P-0%s, Titulo: %s, Genero: %s",
        this.cod, this.titulo, this.genero);
        return infoPelicula;
    }
    
    public boolean alquiler(){
        this.isAlquilada = true;
        fechaAlquiler = LocalDateTime.now();
        //fechaAlquiler = LocalDateTime.of(2024, 12, 03, 12, 00);
        return isAlquilada;
    }
    public boolean devolver(){
        this.isAlquilada = false;
        return isAlquilada;
    }
}
